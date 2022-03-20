package com.auldy.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.auldy.moviecatalogue.data.source.local.LocalDataSource
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.data.source.local.room.Dao
import com.auldy.moviecatalogue.data.source.remote.RemoteDataSource
import com.auldy.moviecatalogue.utils.AppExecutors
import com.auldy.moviecatalogue.utils.DataDummy
import com.auldy.moviecatalogue.utils.PagedListUtil
import com.auldy.moviecatalogue.vo.Resource
import org.junit.Test
import org.junit.Assert.*
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.mockito.Mockito.*
import java.util.concurrent.Executors

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSource = mock(RemoteDataSource::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)

    private val appExecutors = mock(AppExecutors::class.java)
    private val repository = FakeRepository(remoteDataSource, localDataSource, appExecutors)

    private val moviesResponses = DataDummy.generateMovies()
    private val tvShowResponses = DataDummy.generateTvShow()

    @Test
    fun getAllMovies() {
        val dataSource =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(localDataSource.getAllMovies()).thenReturn(dataSource)
        repository.getAllMovies()

        val moviesEntities =
            Resource.success((PagedListUtil.mockPagedList(DataDummy.generateDummyMovies())))
        verify(localDataSource).getAllMovies()
        assertNotNull(moviesEntities.data)
        assertEquals(moviesResponses.size.toLong(), moviesEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSource =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(localDataSource.getAllTvShow()).thenReturn(dataSource)
        repository.getAllTvShow()

        val tvShowEntities =
            Resource.success((PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow())))
        verify(localDataSource).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getAllMoviesFavorite() {
        val dataSource =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(localDataSource.getFavoriteMovies()).thenReturn(dataSource)
        repository.getFavoriteMovies()

        val moviesFavoriteEntities =
            Resource.success((PagedListUtil.mockPagedList(DataDummy.generateDummyMovies())))
        verify(localDataSource).getFavoriteMovies()
        assertNotNull(moviesFavoriteEntities.data)
        assertEquals(moviesResponses.size.toLong(), moviesFavoriteEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShowFavorite() {
        val dataSource =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(localDataSource.getFavoriteTvShow()).thenReturn(dataSource)
        repository.getFavoriteTvShow()

        val tvShowFavoriteEntities =
            Resource.success((PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow())))
        verify(localDataSource).getFavoriteTvShow()
        assertNotNull(tvShowFavoriteEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowFavoriteEntities.data?.size?.toLong())
    }

    @Test
    fun setMovieFavorite() {
        val dataDummy = DataDummy.generateDummyMovies()[0]
        val newState = !dataDummy.favoriteid

        `when`(appExecutors.diskIO()).thenReturn(Executors.newSingleThreadExecutor())
        localDataSource.setMovieFavorite(dataDummy, newState)

        repository.setMoviesFavorite(dataDummy, newState)
        verify(localDataSource, times(1)).setMovieFavorite(dataDummy, newState)
        verifyNoMoreInteractions(localDataSource)
    }

    @Test
    fun setTvShowFavorite() {
        val dataDummy = DataDummy.generateDummyTvShow()[0]
        val newState = !dataDummy.favoriteid

        `when`(appExecutors.diskIO()).thenReturn(Executors.newSingleThreadExecutor())
        localDataSource.setTvShowFavorite(dataDummy, newState)

        repository.setTvShowFavorite(dataDummy, newState)
        verify(localDataSource, times(1)).setTvShowFavorite(dataDummy, newState)
        verifyNoMoreInteractions(localDataSource)
    }

}