package com.andresaftari.submissionfinal.utils.di

import android.content.Context
import com.andresaftari.submissionfinal.data.local.LocalDataSource
import com.andresaftari.submissionfinal.data.local.room.MainDB
import com.andresaftari.submissionfinal.data.remote.DataRepository
import com.andresaftari.submissionfinal.data.remote.dataSource.RemoteDataSource
import com.andresaftari.submissionfinal.utils.executor.AppExecutor
import com.andresaftari.submissionfinal.utils.helper.JSONHelper

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val database = MainDB.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JSONHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.mainDao())
        val appExecutor = AppExecutor()

        return DataRepository.getInstance(remoteDataSource, localDataSource, appExecutor)
    }
}