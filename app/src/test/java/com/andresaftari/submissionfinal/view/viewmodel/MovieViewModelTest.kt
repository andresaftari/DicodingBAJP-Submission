package com.andresaftari.submissionfinal.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.remote.DataRepository
import com.andresaftari.submissionfinal.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Movie>>>

    @Mock
    private lateinit var pagedList: PagedList<Movie>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(dataRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = Resource.success(pagedList)
        `when`(dummyMovie.data?.size).thenReturn(12)

        val movies = MutableLiveData<Resource<PagedList<Movie>>>()
        movies.value = dummyMovie
        `when`(dataRepository.getAllMovies()).thenReturn(movies)

        val entities = movieViewModel.getMovie().value?.data
        verify(dataRepository).getAllMovies()

        assertNotNull(entities)
        assertEquals(12, entities?.size)

        movieViewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}