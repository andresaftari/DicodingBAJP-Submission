package com.andresaftari.submissionfinal.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.remote.DataRepository
import com.andresaftari.submissionfinal.vo.Resource

class MovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getMovie(): LiveData<Resource<PagedList<Movie>>> = dataRepository.getAllMovies()
}