package com.andresaftari.submissionfinal.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.andresaftari.submissionfinal.data.local.LocalDataSource
import com.andresaftari.submissionfinal.data.local.dummy.DummyModel
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail
import com.andresaftari.submissionfinal.data.remote.dataSource.RemoteDataSource
import com.andresaftari.submissionfinal.utils.LiveDataTestUtil
import com.andresaftari.submissionfinal.utils.PagedListUtil
import com.andresaftari.submissionfinal.utils.executor.AppExecutor
import com.andresaftari.submissionfinal.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DataRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSource = mock(RemoteDataSource::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)
    private val appExecutor = mock(AppExecutor::class.java)

    private val fakeRepository = FakeRepository(remoteDataSource, localDataSource, appExecutor)

    private val movieResponse = DummyModel.setRemoteMovieData()
    private val movieId = movieResponse[0].id

    private val showResponse = DummyModel.setRemoteShowData()
    private val showId = showResponse[0].id

    @Test
    fun getAllMovies() {
        val factory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(localDataSource.getAllMovies()).thenReturn(factory)
        fakeRepository.getAllMovies()

        val movies = Resource.success(PagedListUtil.mockPagedList(DummyModel.setMovieData()))
        verify(localDataSource).getAllMovies()

        assertNotNull(movies.data)
        assertEquals(movieResponse.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getFavoritedMovie() {
        val factory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Movie>
        `when`(localDataSource.getFavoritedMovies()).thenReturn(factory)
        fakeRepository.getFavoritedMovie()

        val favMovies = Resource.success(PagedListUtil.mockPagedList(DummyModel.setMovieData()))
        verify(localDataSource).getFavoritedMovies()

        assertNotNull(favMovies.data)
        assertEquals(movieResponse.size.toLong(), favMovies.data?.size?.toLong())
    }

    @Test
    fun getDetailMovies() {
        val details = MutableLiveData<MovieDetail>()
        details.value = DummyModel.setMovieDetail(DummyModel.setMovieData()[0], false)
        `when`(localDataSource.getMovieDetail(movieId)).thenReturn(details)

        val movies = LiveDataTestUtil.getValue(fakeRepository.getDetailMovies(movieId))
        verify(localDataSource).getMovieDetail(movieId)

        assertNotNull(movies.data)
        assertNotNull(movies.data?.details?.title)
        assertEquals(movieResponse[0].title, movies.data?.details?.title)
    }

    @Test
    fun getAllShows() {
        val factory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Show>
        `when`(localDataSource.getAllShows()).thenReturn(factory)
        fakeRepository.getAllShows()

        val shows = Resource.success(PagedListUtil.mockPagedList(DummyModel.setShowData()))
        verify(localDataSource).getAllShows()

        assertNotNull(shows.data)
        assertEquals(showResponse.size.toLong(), shows.data?.size?.toLong())
    }

    @Test
    fun getFavoritedShow() {
        val factory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Show>
        `when`(localDataSource.getFavoritedShows()).thenReturn(factory)
        fakeRepository.getFavoritedShow()

        val favShows = Resource.success(PagedListUtil.mockPagedList(DummyModel.setShowData()))
        verify(localDataSource).getFavoritedShows()

        assertNotNull(favShows.data)
        assertEquals(showResponse.size.toLong(), favShows.data?.size?.toLong())
    }

    @Test
    fun getDetailShows() {
        val details = MutableLiveData<ShowDetail>()
        details.value = DummyModel.setShowDetail(DummyModel.setShowData()[0], false)
        `when`(localDataSource.getShowDetail(showId)).thenReturn(details)

        val shows = LiveDataTestUtil.getValue(fakeRepository.getDetailShows(showId))
        verify(localDataSource).getShowDetail(showId)

        assertNotNull(shows.data)
        assertNotNull(shows.data?.details?.title)
        assertEquals(showResponse[0].title, shows.data?.details?.title)
    }
}