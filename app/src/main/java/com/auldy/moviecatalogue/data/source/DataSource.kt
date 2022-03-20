package com.auldy.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.vo.Resource

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
interface DataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>>
    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getDetailMovies(moviesId: String): LiveData<Resource<MoviesEntity>>
    fun getDetailTvShow(tvshowId: String): LiveData<Resource<TvShowEntity>>
    fun getFavoriteMovies(): LiveData<PagedList<MoviesEntity>>
    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>
    fun setMoviesFavorite(movies: MoviesEntity, state: Boolean)
    fun setTvShowFavorite(tvshow: TvShowEntity, state: Boolean)
}