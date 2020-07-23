package com.andresaftari.submissionfinal.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail
import com.andresaftari.submissionfinal.data.remote.DataRepository
import com.andresaftari.submissionfinal.vo.Resource

class DetailViewModel(private val dataRepository: DataRepository) : ViewModel() {
    val id = MutableLiveData<String>()

    // Movie
    fun setSelected(itemID: String) {
        this.id.value = itemID
    }

    var movieDetail: LiveData<Resource<MovieDetail>> =
        Transformations.switchMap(id) { movieID ->
            dataRepository.getDetailMovies(movieID)
        }

    fun setFavoritedMovie() {
        val detailRes = movieDetail.value
        if (detailRes != null) {
            val detail = detailRes.data

            if (detail != null) {
                val movie = detail.movie
                val newState = !movie.favorited
                dataRepository.setMovieFavorited(movie, newState)
            }
        }
    }

    var showDetail: LiveData<Resource<ShowDetail>> =
        Transformations.switchMap(id) { showID ->
            dataRepository.getDetailShows(showID)
        }

    fun setFavoritedShow() {
        val detailRes = showDetail.value
        if (detailRes != null) {
            val detail = detailRes.data

            if (detail != null) {
                val show = detail.show
                val newState = !show.favorited
                dataRepository.setShowFavorited(show, newState)
            }
        }
    }
}