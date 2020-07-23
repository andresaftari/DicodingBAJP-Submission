package com.andresaftari.submissionfinal.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andresaftari.submissionfinal.R
import com.andresaftari.submissionfinal.utils.adapter.MovieAdapter
import com.andresaftari.submissionfinal.utils.factory.ViewModelFactory
import com.andresaftari.submissionfinal.view.viewmodel.MovieViewModel
import com.andresaftari.submissionfinal.vo.Status
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewmodel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            viewmodel.getMovie().observe(this, Observer { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar.visibility = View.GONE

                            try {
                                movieAdapter.apply {
                                    submitList(movies.data)
                                    notifyDataSetChanged()
                                }
                            } catch (e: Exception) {
                                Log.i(
                                    "MovieFragment.loadMovie",
                                    "Failed! ${e.message} - ${e.printStackTrace()}"
                                )
                            }
                        }
                        Status.ERROR -> {
                            progress_bar.visibility = View.GONE
                            Toast.makeText(
                                context,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })

            rv_movies?.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = movieAdapter
            }
        }
    }
}