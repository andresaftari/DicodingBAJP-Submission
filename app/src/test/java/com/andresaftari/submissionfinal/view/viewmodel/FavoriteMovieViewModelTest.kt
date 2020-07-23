package com.andresaftari.submissionfinal.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.remote.DataRepository
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
class FavoriteMovieViewModelTest {
    private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<PagedList<Movie>>

    @Mock
    private lateinit var pagedList: PagedList<Movie>

    @Before
    fun setUp() {
        favoriteMovieViewModel = FavoriteMovieViewModel(dataRepository)
    }

    @Test
    fun getFavoritedMovie() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(12)

        val movies = MutableLiveData<PagedList<Movie>>()
        movies.value = dummyMovies
        `when`(dataRepository.getFavoritedMovie()).thenReturn(movies)

        val entities = favoriteMovieViewModel.getFavoritedMovie().value
        verify(dataRepository).getFavoritedMovie()
        assertNotNull(entities)
        assertEquals(12, entities?.size)

        favoriteMovieViewModel.getFavoritedMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}