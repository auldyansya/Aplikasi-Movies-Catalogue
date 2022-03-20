package com.auldy.moviecatalogue.ui.tvshow

import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity

interface TvShowCallback {
    fun onShareClick(tvshow: TvShowEntity)
}