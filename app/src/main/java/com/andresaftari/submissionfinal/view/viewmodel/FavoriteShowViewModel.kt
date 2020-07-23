package com.andresaftari.submissionfinal.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.remote.DataRepository

class FavoriteShowViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getFavoritedShow(): LiveData<PagedList<Show>> = dataRepository.getFavoritedShow()

    fun setFavoritedShow(show: Show) {
        val newState = !show.favorited
        dataRepository.setShowFavorited(show, newState)
    }
}