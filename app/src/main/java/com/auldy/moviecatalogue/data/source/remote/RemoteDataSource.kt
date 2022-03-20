package com.auldy.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.auldy.moviecatalogue.data.source.remote.response.MoviesResponse
import com.auldy.moviecatalogue.data.source.remote.response.TvShowResponse
import com.auldy.moviecatalogue.utils.EspressoIdlingResources
import com.auldy.moviecatalogue.utils.JsonHelper

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MoviesResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MoviesResponse>>>()
        handler.postDelayed(
            {
                resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
                EspressoIdlingResources.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
        return resultMovies
    }

    fun getAllTvShow(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed(
            {
                resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShow())
                EspressoIdlingResources.decrement()
            }, SERVICE_LATENCY_IN_MILLIS
        )
        return resultTvShow
    }
}
