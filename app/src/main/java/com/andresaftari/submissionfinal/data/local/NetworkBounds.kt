package com.andresaftari.submissionfinal.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.andresaftari.submissionfinal.data.remote.ApiResponse
import com.andresaftari.submissionfinal.data.remote.StatusResponse
import com.andresaftari.submissionfinal.utils.executor.AppExecutor
import com.andresaftari.submissionfinal.vo.Resource

abstract class NetworkBounds<ResultType, RequestType>(private val appExecutor: AppExecutor) {
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)

            if (shouldFetch(data)) fetchFromNetwork(dbSource)
            else result.addSource(dbSource) { newData -> result.value = Resource.success(newData) }
        }
    }

    protected open fun onFetchFailed() {}
    protected abstract fun loadFromDB(): LiveData<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()

        result.addSource(dbSource) { newData -> result.value = Resource.loading(newData) }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)

            when (response.status) {
                StatusResponse.SUCCESS ->
                    appExecutor.diskIO().execute {
                        saveCallResult(response.body)
                        appExecutor.mainThread().execute {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = Resource.success(newData)
                            }
                        }
                    }
                StatusResponse.EMPTY -> appExecutor.mainThread().execute {
                    result.addSource(loadFromDB()) { newdata ->
                        result.value = Resource.success(newdata)
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newdata ->
                        result.value = Resource.error(response.message, newdata)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}