package com.auldy.moviecatalogue.ui.movies

import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity

interface MoviesCallback {
    fun onShareClick(movies: MoviesEntity)
}