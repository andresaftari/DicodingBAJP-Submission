package com.andresaftari.submissionfinal.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Show
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
class ShowViewModelTest {
    private lateinit var showViewModel: ShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Show>>>

    @Mock
    private lateinit var pagedList: PagedList<Show>

    @Before
    fun setUp() {
        showViewModel = ShowViewModel(dataRepository)
    }

    @Test
    fun getShow() {
        val dummyShow = Resource.success(pagedList)
        `when`(dummyShow.data?.size).thenReturn(11)

        val shows = MutableLiveData<Resource<PagedList<Show>>>()
        shows.value = dummyShow
        `when`(dataRepository.getAllShows()).thenReturn(shows)

        val entities = showViewModel.getShow().value?.data
        verify(dataRepository).getAllShows()

        assertNotNull(entities)
        assertEquals(11, entities?.size)

        showViewModel.getShow().observeForever(observer)
        verify(observer).onChanged(dummyShow)
    }
}