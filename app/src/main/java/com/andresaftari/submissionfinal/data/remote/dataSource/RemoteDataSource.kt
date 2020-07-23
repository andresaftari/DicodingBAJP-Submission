package com.andresaftari.submissionfinal.data.remote.dataSource

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andresaftari.submissionfinal.data.remote.ApiResponse
import com.andresaftari.submissionfinal.data.remote.response.DataResponse
import com.andresaftari.submissionfinal.utils.IdleResource
import com.andresaftari.submissionfinal.utils.helper.JSONHelper

class RemoteDataSource private constructor(private val jsonHelper: JSONHelper) {
    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(jsonHelper: JSONHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(jsonHelper)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<DataResponse>>> {
        IdleResource.increment()
        val movie = MutableLiveData<ApiResponse<List<DataResponse>>>()

        handler.postDelayed({
            movie.value = ApiResponse.success(jsonHelper.loadMovies())
            IdleResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return movie
    }

    fun getAllShows(): LiveData<ApiResponse<List<DataResponse>>> {
        IdleResource.increment()
        val show = MutableLiveData<ApiResponse<List<DataResponse>>>()

        handler.postDelayed({
            show.value = ApiResponse.success(jsonHelper.loadShows())
            IdleResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return show
    }
}