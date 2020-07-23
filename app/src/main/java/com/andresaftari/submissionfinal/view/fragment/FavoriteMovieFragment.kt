package com.andresaftari.submissionfinal.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andresaftari.submissionfinal.R
import com.andresaftari.submissionfinal.utils.adapter.FavoriteMovieAdapter
import com.andresaftari.submissionfinal.utils.factory.ViewModelFactory
import com.andresaftari.submissionfinal.view.viewmodel.FavoriteMovieViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_movie.*

class FavoriteMovieFragment : Fragment() {
    private lateinit var favoriteMovieViewModel: FavoriteMovieViewModel
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite_movie, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(rv_favorite_movie)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            favoriteMovieViewModel =
                ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            favoriteMovieAdapter = FavoriteMovieAdapter()
            progress_bar.visibility = View.VISIBLE

            favoriteMovieViewModel.getFavoritedMovie().observe(this, Observer { movies ->
                progress_bar.visibility = View.GONE

                favoriteMovieAdapter.apply {
                    submitList(movies)
                    notifyDataSetChanged()
                }
            })

            rv_favorite_movie.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = favoriteMovieAdapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val getSwipedPosition = viewHolder.adapterPosition
                val movie = favoriteMovieAdapter.getSwipedData(getSwipedPosition)

                movie?.let { favoriteMovieViewModel.setFavoritedMovie(it) }

                Snackbar.make(
                    view as View, R.string.message_undo, Snackbar.LENGTH_SHORT
                ).setAction(R.string.message_ok) { _ ->
                    movie?.let { favoriteMovieViewModel.setFavoritedMovie(it) }
                }.show()
            }
        }
    })
}