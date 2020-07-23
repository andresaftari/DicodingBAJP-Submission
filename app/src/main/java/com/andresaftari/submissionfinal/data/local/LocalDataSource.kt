package com.andresaftari.submissionfinal.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail
import com.andresaftari.submissionfinal.data.local.room.MainDAO

class LocalDataSource private constructor(private val mainDAO: MainDAO) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mainDAO: MainDAO): LocalDataSource =
            INSTANCE ?: LocalDataSource(mainDAO)
    }

    // Movie
    fun getAllMovies(): DataSource.Factory<Int, Movie> = mainDAO.getAllMovies()
    fun getFavoritedMovies(): DataSource.Factory<Int, Movie> = mainDAO.getFavoritedMovie()
    fun getMovieDetail(movieId: String): LiveData<MovieDetail> = mainDAO.getDetailByMovieID(movieId)
    fun insertMovie(movies: List<Movie>) = mainDAO.insertMovies(movies)

    fun setFavoritedMovie(movie: Movie, newState: Boolean) {
        movie.favorited = newState
        mainDAO.movieToFavorite(movie)
    }

    // Show
    fun getAllShows(): DataSource.Factory<Int, Show> = mainDAO.getAllShows()
    fun getFavoritedShows(): DataSource.Factory<Int, Show> = mainDAO.getFavoritedShow()
    fun getShowDetail(showId: String): LiveData<ShowDetail> = mainDAO.getDetailByShowID(showId)
    fun insertShow(shows: List<Show>) = mainDAO.insertShows(shows)

    fun setFavoritedShow(show: Show, newState: Boolean) {
        show.favorited = newState
        mainDAO.showToFavorite(show)
    }
}