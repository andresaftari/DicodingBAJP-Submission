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
import com.andresaftari.submissionfinal.utils.adapter.FavoriteShowAdapter
import com.andresaftari.submissionfinal.utils.factory.ViewModelFactory
import com.andresaftari.submissionfinal.view.viewmodel.FavoriteShowViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite_show.*
import kotlinx.android.synthetic.main.fragment_show.progress_bar

class FavoriteShowFragment : Fragment() {
    private lateinit var favoriteShowViewModel: FavoriteShowViewModel
    private lateinit var favoriteShowAdapter: FavoriteShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_favorite_show, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(rv_favorite_show)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            favoriteShowViewModel =
                ViewModelProvider(this, factory)[FavoriteShowViewModel::class.java]

            favoriteShowAdapter = FavoriteShowAdapter()
            progress_bar.visibility = View.VISIBLE

            favoriteShowViewModel.getFavoritedShow().observe(this, Observer { shows ->
                progress_bar.visibility = View.GONE

                favoriteShowAdapter.apply {
                    submitList(shows)
                    notifyDataSetChanged()
                }
            })

            rv_favorite_show.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = favoriteShowAdapter
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
                val show = favoriteShowAdapter.getSwipedData(getSwipedPosition)

                show?.let { favoriteShowViewModel.setFavoritedShow(it) }

                Snackbar.make(
                    view as View, R.string.message_undo, Snackbar.LENGTH_SHORT
                ).setAction(R.string.message_ok) { _ ->
                    show?.let { favoriteShowViewModel.setFavoritedShow(it) }
                }.show()
            }
        }
    })
}