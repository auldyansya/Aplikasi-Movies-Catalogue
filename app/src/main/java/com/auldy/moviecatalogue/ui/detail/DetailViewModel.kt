package com.auldy.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.vo.Resource

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class DetailViewModel(private val repository: Repository) : ViewModel() {

    private var moviesId = MutableLiveData<String>()
    private var tvShowId = MutableLiveData<String>()


    fun setSelectedMovies(moviesId: String) {
        this.moviesId.value = moviesId
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var movies: LiveData<Resource<MoviesEntity>> = Transformations.switchMap(moviesId) { movieId ->
        repository.getDetailMovies(movieId)
    }

    var tvShow: LiveData<Resource<TvShowEntity>> =
        Transformations.switchMap(tvShowId) { tvShowId ->
            repository.getDetailTvShow(tvShowId)
        }

    fun setFavorite() {

        val resourceMovie = movies.value
        if (resourceMovie != null) {
            val movieWithData = resourceMovie.data

            if (movieWithData != null) {
                val newState = !movieWithData.favoriteid
                repository.setMoviesFavorite(movieWithData, newState)
            }
        }

        val resourceTvShow = tvShow.value
        if (resourceTvShow != null) {
            val tvShowWithData = resourceTvShow.data

            if (tvShowWithData != null) {
                val newState = !tvShowWithData.favoriteid
                repository.setTvShowFavorite(tvShowWithData, newState)
            }
        }
    }
}