package com.auldy.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoriteTvShowViewModel(private val repository: Repository) :
    ViewModel() {

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> =
        repository.getFavoriteTvShow()

    fun setFavoriteTvShow(tvshow: TvShowEntity) {
        val newState = !tvshow.favoriteid
        repository.setTvShowFavorite(tvshow, newState)
    }
}