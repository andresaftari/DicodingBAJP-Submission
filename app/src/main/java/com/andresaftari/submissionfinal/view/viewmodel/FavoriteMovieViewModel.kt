package com.andresaftari.submissionfinal.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.remote.DataRepository

class FavoriteMovieViewModel(private val dataRepository: DataRepository) : ViewModel() {
    fun getFavoritedMovie(): LiveData<PagedList<Movie>> = dataRepository.getFavoritedMovie()

    fun setFavoritedMovie(movie: Movie) {
        val newState = !movie.favorited
        dataRepository.setMovieFavorited(movie, newState)
    }
}