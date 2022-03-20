package com.auldy.moviecatalogue.ui.favorite.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoriteMoviesViewModel(private val repository: Repository) :
    ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MoviesEntity>> =
        repository.getFavoriteMovies()

    fun setFavoriteMovies(movies: MoviesEntity) {
        val newState = !movies.favoriteid
        repository.setMoviesFavorite(movies, newState)
    }
}