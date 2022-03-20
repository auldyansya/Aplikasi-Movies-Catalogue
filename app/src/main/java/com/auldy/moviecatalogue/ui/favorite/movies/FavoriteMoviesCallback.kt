package com.auldy.moviecatalogue.ui.favorite.movies

import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity

interface FavoriteMoviesCallback {
    fun onShareClick(movies: MoviesEntity)
}