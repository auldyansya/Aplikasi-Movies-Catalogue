package com.auldy.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.auldy.moviecatalogue.data.source.Repository
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.utils.DataDummy
import com.auldy.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val moviesId = dummyMovies.moviesid

    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val tvshowId = dummyTvShow.tvshowid

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observerMovies: Observer<Resource<MoviesEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowEntity>>

    @Before
    fun setUpMovie() {
        viewModel = DetailViewModel(repository)
        viewModel.setSelectedMovies(moviesId)
        viewModel.setSelectedTvShow(tvshowId)
    }

    @Test
    fun getMovies() {
        val detailMovies = Resource.success(DataDummy.generateDummyMovies()[0])
        val movies = MutableLiveData<Resource<MoviesEntity>>()
        movies.value = detailMovies

        `when`(repository.getDetailMovies(moviesId)).thenReturn(movies)
        viewModel.movies.observeForever(observerMovies)
        verify(observerMovies).onChanged(detailMovies)
    }

    @Test
    fun getTvShow() {
        val detailTvShow = Resource.success(DataDummy.generateDummyTvShow()[0])
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = detailTvShow

        `when`(repository.getDetailTvShow(tvshowId)).thenReturn(tvShow)
        viewModel.tvShow.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(detailTvShow)
    }

    @Test
    fun setFavoriteMovies() {
        val dummyMovieFavorite = Resource.success(DataDummy.generateDummyMovies()[0])
        val movies = MutableLiveData<Resource<MoviesEntity>>()
        val newState = !dummyMovies.favoriteid
        movies.value = dummyMovieFavorite
        `when`(repository.getDetailMovies(moviesId)).thenReturn(movies)

        doNothing().`when`(repository).setMoviesFavorite(dummyMovies, newState)
        viewModel.movies.observeForever(observerMovies)
        viewModel.setFavorite()
        verify(repository, Mockito.times(1)).setMoviesFavorite(dummyMovies, newState)
    }

    @Test
    fun setFavoriteTvShow() {
        val dummyTvShowFavorite = Resource.success(DataDummy.generateDummyTvShow()[0])
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        val newState = !dummyTvShow.favoriteid
        tvShow.value = dummyTvShowFavorite
        `when`(repository.getDetailTvShow(tvshowId)).thenReturn(tvShow)

        doNothing().`when`(repository).setTvShowFavorite(dummyTvShow, newState)
        viewModel.tvShow.observeForever(observerTvShow)
        viewModel.setFavorite()
        verify(repository, Mockito.times(1)).setTvShowFavorite(dummyTvShow, newState)
    }
}