package com.auldy.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.auldy.moviecatalogue.data.source.local.LocalDataSource
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.data.source.remote.ApiResponse
import com.auldy.moviecatalogue.data.source.remote.RemoteDataSource
import com.auldy.moviecatalogue.data.source.remote.response.MoviesResponse
import com.auldy.moviecatalogue.data.source.remote.response.TvShowResponse
import com.auldy.moviecatalogue.utils.AppExecutors
import com.auldy.moviecatalogue.vo.Resource


/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteDataSource, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MoviesEntity>, List<MoviesResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MoviesResponse>) {
                val listMovies = ArrayList<MoviesEntity>()

                for (response in data) {
                    val movies = MoviesEntity(
                        response.moviesid,
                        response.background,
                        response.poster,
                        response.title,
                        response.releasedate,
                        response.genre,
                        response.durasi,
                        response.average,
                        response.tagline,
                        response.overview,
                        response.status,
                        response.language,
                        response.budget,
                        response.revenue,
                        false
                    )
                    listMovies.add(movies)
                }
                localDataSource.insertMovies(listMovies)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MoviesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShow()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val listTvShow = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvshowid,
                        response.background,
                        response.poster,
                        response.title,
                        response.releasedate,
                        response.genre,
                        response.durasi,
                        response.average,
                        response.tagline,
                        response.overview,
                        response.status,
                        response.language,
                        response.budget,
                        response.revenue,
                        false
                    )
                    listTvShow.add(tvShow)
                }
                localDataSource.insertTvShow(listTvShow)
            }
        }.asLiveData()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun getDetailMovies(moviesId: String): LiveData<Resource<MoviesEntity>> {
        return object :
            NetworkBoundResource<MoviesEntity, List<MoviesResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<MoviesEntity> =
                localDataSource.getDetailMovies(moviesId)

            override fun shouldFetch(data: MoviesEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MoviesResponse>) {
                val listMovies = ArrayList<MoviesEntity>()
                for (response in data) {
                    val movies = MoviesEntity(
                        response.moviesid,
                        response.background,
                        response.poster,
                        response.title,
                        response.releasedate,
                        response.genre,
                        response.durasi,
                        response.average,
                        response.tagline,
                        response.overview,
                        response.status,
                        response.language,
                        response.budget,
                        response.revenue,
                        false
                    )
                    listMovies.add(movies)
                }
                localDataSource.insertMovies(listMovies)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvshowId: String): LiveData<Resource<TvShowEntity>> {
        return object :
            NetworkBoundResource<TvShowEntity, List<TvShowResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShow(tvshowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShow()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val listTvShow = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvshow = TvShowEntity(
                        response.tvshowid,
                        response.background,
                        response.poster,
                        response.title,
                        response.releasedate,
                        response.genre,
                        response.durasi,
                        response.average,
                        response.tagline,
                        response.overview,
                        response.status,
                        response.language,
                        response.budget,
                        response.revenue,
                        false
                    )
                    listTvShow.add(tvshow)
                }

                localDataSource.insertTvShow(listTvShow)
            }
        }.asLiveData()
    }

    override fun setMoviesFavorite(movies: MoviesEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movies, state) }

    override fun setTvShowFavorite(tvshow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvshow, state) }
}