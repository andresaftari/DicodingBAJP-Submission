package com.andresaftari.submissionfinal.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.remote.DataRepository
import com.andresaftari.submissionfinal.vo.Resource

class ShowViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getShow(): LiveData<Resource<PagedList<Show>>> = dataRepository.getAllShows()
}