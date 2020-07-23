package com.andresaftari.submissionfinal.utils.loader

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail
import com.andresaftari.submissionfinal.vo.Resource

interface LoadDataSource {
    // Movie
    fun getAllMovies(): LiveData<Resource<PagedList<Movie>>>
    fun getDetailMovies(movieId: String): LiveData<Resource<MovieDetail>>
    fun getFavoritedMovie(): LiveData<PagedList<Movie>>
    fun setMovieFavorited(movie: Movie, state: Boolean)

    // Show
    fun getAllShows(): LiveData<Resource<PagedList<Show>>>
    fun getDetailShows(showId: String): LiveData<Resource<ShowDetail>>
    fun getFavoritedShow(): LiveData<PagedList<Show>>
    fun setShowFavorited(show: Show, state: Boolean)
}