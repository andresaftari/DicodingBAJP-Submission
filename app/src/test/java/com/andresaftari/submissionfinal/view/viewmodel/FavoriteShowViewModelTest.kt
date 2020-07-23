package com.andresaftari.submissionfinal.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.remote.DataRepository
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteShowViewModelTest {
    private lateinit var favoriteShowViewModel: FavoriteShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<PagedList<Show>>

    @Mock
    private lateinit var pagedList: PagedList<Show>
    
    @Before
    fun setUp() {
        favoriteShowViewModel = FavoriteShowViewModel(dataRepository)
    }

    @Test
    fun getFavoritedShow() {
        val dummyShows = pagedList
        Mockito.`when`(dummyShows.size).thenReturn(11)

        val shows = MutableLiveData<PagedList<Show>>()
        shows.value = dummyShows
        Mockito.`when`(dataRepository.getFavoritedShow()).thenReturn(shows)

        val entities = favoriteShowViewModel.getFavoritedShow().value
        verify(dataRepository).getFavoritedShow()
        assertNotNull(entities)
        assertEquals(11, entities?.size)

        favoriteShowViewModel.getFavoritedShow().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}