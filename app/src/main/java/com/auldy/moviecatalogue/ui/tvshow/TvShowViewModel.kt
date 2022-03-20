package com.auldy.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.vo.Resource

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class TvShowViewModel(private val tvshowRepository: Repository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = tvshowRepository.getAllTvShow()

}