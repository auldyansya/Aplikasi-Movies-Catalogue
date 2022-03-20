package com.auldy.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.ui.detail.DetailViewModel
import com.auldy.moviecatalogue.di.Injection
import com.auldy.moviecatalogue.ui.favorite.movies.FavoriteMoviesViewModel
import com.auldy.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowViewModel
import com.auldy.moviecatalogue.ui.movies.MoviesViewModel
import com.auldy.moviecatalogue.ui.tvshow.TvShowViewModel

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class ViewModelFactory private constructor(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(
                    repository
                ) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(
                    repository
                ) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(
                    repository
                ) as T
            }
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> {
                return FavoriteMoviesViewModel(
                    repository
                ) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                return FavoriteTvShowViewModel(
                    repository
                ) as T
            }
            else -> throw Throwable("Unknown View Model class: " + modelClass.name)
        }
    }
}