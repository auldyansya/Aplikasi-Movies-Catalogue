package com.auldy.moviecatalogue.ui.favorite.tvshow

import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity

interface FavoriteTvShowCallback {
    fun onShareClick(tvshow: TvShowEntity)
}