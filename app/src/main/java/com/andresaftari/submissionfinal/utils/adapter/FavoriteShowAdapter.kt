package com.andresaftari.submissionfinal.utils.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.andresaftari.submissionfinal.R
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.view.activity.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_item.view.*

class FavoriteShowAdapter internal constructor() :
    PagedListAdapter<Show, FavoriteShowAdapter.FavoriteShowViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Show>() {
            override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean {
                return oldItem.showId == newItem.showId
            }

            override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): Show? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteShowViewHolder =
        FavoriteShowViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )

    override fun onBindViewHolder(holder: FavoriteShowViewHolder, position: Int) {
        val favorited = getItem(position)
        if (favorited != null) holder.bind(favorited)
    }

    inner class FavoriteShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(show: Show) {
            with(itemView) {
                tv_title?.text = show.title
                tv_genre?.text = show.genre

                Glide.with(context)
                    .load(show.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_refresh_black)
                            .error(R.drawable.ic_broken_image_black)
                            .override(80, 80)
                    )
                    .into(iv_poster)

                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_SHOW, show.showId)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }
}