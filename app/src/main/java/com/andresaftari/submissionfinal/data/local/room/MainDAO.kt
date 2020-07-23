package com.andresaftari.submissionfinal.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail

@Dao
interface MainDAO {
    // Movie
    @Query("SELECT * FROM movie")
    fun getAllMovies(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM movie WHERE favorited = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, Movie>

    @Transaction
    @Query("SELECT * FROM movie WHERE movieId = :movieId")
    fun getDetailByMovieID(movieId: String): LiveData<MovieDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<Movie>)

    @Update
    fun movieToFavorite(movie: Movie)

    // Show
    @Query("SELECT * FROM show")
    fun getAllShows(): DataSource.Factory<Int, Show>

    @Query("SELECT * FROM show WHERE favorited = 1")
    fun getFavoritedShow(): DataSource.Factory<Int, Show>

    @Transaction
    @Query("SELECT * FROM show WHERE showId = :showId")
    fun getDetailByShowID(showId: String): LiveData<ShowDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: List<Show>)

    @Update
    fun showToFavorite(show: Show)
}