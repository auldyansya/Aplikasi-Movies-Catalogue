package com.auldy.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.data.source.local.room.Dao

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class LocalDataSource private constructor(private val dao: Dao) {

    companion object {

        private var INSTANCE: LocalDataSource? = null

        fun getInstance(dao: Dao): LocalDataSource =
            INSTANCE ?: LocalDataSource(dao).apply {
                INSTANCE =this
            }
    }

    fun getAllMovies(): DataSource.Factory<Int, MoviesEntity> = dao.getMovies()

    fun getFavoriteMovies(): DataSource.Factory<Int, MoviesEntity> =
        dao.getFavoriteMovies()

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = dao.getTvShow()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> =
        dao.getFavoriteTvShow()

    fun getDetailMovies(moviesId: String): LiveData<MoviesEntity> =
        dao.getDetailMovies(moviesId)

    fun getDetailTvShow(tvShowId: String): LiveData<TvShowEntity> =
        dao.getDetailTvShow(tvShowId)

    fun insertMovies(movies: List<MoviesEntity>) = dao.insertMovies(movies)

    fun insertTvShow(tvShow: List<TvShowEntity>) = dao.insertTvShow(tvShow)

    fun setMovieFavorite(movie: MoviesEntity, newState: Boolean) {
        movie.favoriteid = newState
        dao.updateMovies(movie)
    }

    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favoriteid = newState
        dao.updateTvShow(tvShow)
    }


}