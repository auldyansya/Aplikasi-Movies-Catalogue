package com.auldy.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.vo.Resource

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MoviesEntity>>> =
        repository.getAllMovies()

}