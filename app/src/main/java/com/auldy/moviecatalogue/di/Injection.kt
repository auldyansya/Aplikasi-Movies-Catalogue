package com.auldy.moviecatalogue.di

import android.content.Context
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.data.source.local.LocalDataSource
import com.auldy.moviecatalogue.data.source.local.room.DatabaseCatalogue
import com.auldy.moviecatalogue.data.source.remote.RemoteDataSource
import com.auldy.moviecatalogue.utils.AppExecutors
import com.auldy.moviecatalogue.utils.JsonHelper

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
object Injection {

    fun provideRepository(context: Context): Repository {
        val database = DatabaseCatalogue.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.Dao())
        val appExecutors = AppExecutors()

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}