package com.andresaftari.submissionfinal.view.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andresaftari.submissionfinal.R
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.utils.factory.ViewModelFactory
import com.andresaftari.submissionfinal.view.viewmodel.DetailViewModel
import com.andresaftari.submissionfinal.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var detailViewModel: DetailViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        val getExtras = intent.extras

        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        if (getExtras != null) {
            val movieId = getExtras.getString(EXTRA_MOVIE)
            val showId = getExtras.getString(EXTRA_SHOW)

            if (movieId != null) {
                detailViewModel.setSelected(movieId)

                detailViewModel.movieDetail.observe(this, Observer { detailRes ->
                    if (detailRes != null) {
                        when (detailRes.status) {
                            Status.LOADING -> {
                                Toast.makeText(
                                    applicationContext,
                                    "Loading data...",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            Status.SUCCESS -> if (detailRes.data != null) {
                                try {
                                    populateMovie(detailRes.data.movie)
                                } catch (e: Exception) {
                                    Log.i(
                                        "DetailActivity.onCreate",
                                        "Failed to load! ${e.message} - ${e.printStackTrace()}"
                                    )
                                }
                            }
                            Status.ERROR -> {
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }

            if (showId != null) {
                detailViewModel.setSelected(showId)

                detailViewModel.showDetail.observe(this, Observer { detailRes ->
                    if (detailRes != null) {
                        when (detailRes.status) {
                            Status.LOADING -> {
                                Toast.makeText(
                                    applicationContext,
                                    "Loading data...",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            Status.SUCCESS -> if (detailRes.data != null) {
                                try {
                                    populateShow(detailRes.data.show)
                                } catch (e: Exception) {
                                    Log.i(
                                        "DetailActivity.onCreate",
                                        "Failed to load! ${e.message} - ${e.printStackTrace()}"
                                    )
                                }
                            }
                            Status.ERROR -> {
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            detailViewModel.setFavoritedMovie()
            detailViewModel.setFavoritedShow()

            Toast.makeText(
                applicationContext,
                "Successfully added to favorite!",
                Toast.LENGTH_SHORT
            ).show()

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu
        detailViewModel.movieDetail.observe(this, Observer { detailRes ->
            if (detailRes != null) {
                when (detailRes.status) {
                    Status.LOADING -> {
                        Toast.makeText(
                            applicationContext,
                            "Loading data...",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Status.SUCCESS -> if (detailRes.data != null) {
                        try {
                            val newState = detailRes.data.details.favorited
                            setFavorited(newState)
                        } catch (e: Exception) {
                            Log.i(
                                "DetailActivity.onCreateMenu",
                                "Failed! ${e.message} - ${e.printStackTrace()}"
                            )
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            applicationContext,
                            "Terjadi kesalahan",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })

        detailViewModel.showDetail.observe(this, Observer { detailRes ->
            if (detailRes != null) {
                when (detailRes.status) {
                    Status.LOADING -> {
                        Toast.makeText(
                            applicationContext,
                            "Loading data...",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Status.SUCCESS -> if (detailRes.data != null) {
                        try {
                            val newState = detailRes.data.details.favorited
                            setFavorited(newState)
                        } catch (e: Exception) {
                            Log.i(
                                "DetailActivity.onCreateMenu",
                                "Failed! ${e.message} - ${e.printStackTrace()}"
                            )
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            applicationContext,
                            "Terjadi kesalahan",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
        return true
    }

    private fun populateMovie(movie: Movie) {
        supportActionBar?.title = movie.title

        tv_detail_title?.text = movie.title
        tv_detail_genre?.text = movie.genre
        tv_detail_description?.text = movie.description

        Glide.with(this)
            .load(movie.imagePath)
            .apply(
                RequestOptions
                    .placeholderOf(R.drawable.ic_refresh_black)
                    .error(R.drawable.ic_broken_image_black)
            )
            .into(iv_detail_poster)
    }

    private fun populateShow(show: Show) {
        supportActionBar?.title = show.title

        tv_detail_title?.text = show.title
        tv_detail_genre?.text = show.genre
        tv_detail_description?.text = show.description

        Glide.with(this)
            .load(show.imagePath)
            .apply(
                RequestOptions
                    .placeholderOf(R.drawable.ic_refresh_black)
                    .error(R.drawable.ic_broken_image_black)
            )
            .into(iv_detail_poster)
    }

    private fun setFavorited(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)

        if (state) menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_on)
        else menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_off)
    }
}