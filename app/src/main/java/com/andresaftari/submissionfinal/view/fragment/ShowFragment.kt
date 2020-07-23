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
import com.andresaftari.submissionfinal.utils.adapter.ShowAdapter
import com.andresaftari.submissionfinal.utils.factory.ViewModelFactory
import com.andresaftari.submissionfinal.view.viewmodel.ShowViewModel
import com.andresaftari.submissionfinal.vo.Status
import kotlinx.android.synthetic.main.fragment_show.*

class ShowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_show, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewmodel = ViewModelProvider(this, factory)[ShowViewModel::class.java]

            val showAdapter = ShowAdapter()
            viewmodel.getShow().observe(this, Observer { shows ->
                if (shows != null) {
                    when (shows.status) {
                        Status.LOADING -> progress_bar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            progress_bar.visibility = View.GONE

                            try {
                                showAdapter.apply {
                                    submitList(shows.data)
                                    notifyDataSetChanged()
                                }
                            } catch (e: Exception) {
                                Log.i(
                                    "ShowFragment.loadShow",
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

            rv_shows?.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = showAdapter
            }
        }
    }
}