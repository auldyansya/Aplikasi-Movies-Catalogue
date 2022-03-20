package com.auldy.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.room.Dao
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
@Dao
interface Dao {

    @Query("SELECT * FROM moviesentities")
    fun getMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM moviesentities WHERE favoriteid = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities WHERE favoriteid = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM moviesentities WHERE moviesid = :id")
    fun getDetailMovies(id: String): LiveData<MoviesEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvshowid = :id")
    fun getDetailTvShow(id: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MoviesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvshow: List<TvShowEntity>)

    @Update
    fun updateMovies(movies: MoviesEntity)

    @Update
    fun updateTvShow(tvshow: TvShowEntity)
}