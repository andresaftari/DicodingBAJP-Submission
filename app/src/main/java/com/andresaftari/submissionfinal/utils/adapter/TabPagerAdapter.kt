package com.andresaftari.submissionfinal.utils.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.andresaftari.submissionfinal.R
import com.andresaftari.submissionfinal.view.fragment.FavoriteMovieFragment
import com.andresaftari.submissionfinal.view.fragment.FavoriteShowFragment
import com.andresaftari.submissionfinal.view.fragment.MovieFragment
import com.andresaftari.submissionfinal.view.fragment.ShowFragment

class TabPagerAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES =
            intArrayOf(R.string.movies, R.string.tv_show, R.string.favorite_m, R.string.favorite_s)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> ShowFragment()
            2 -> FavoriteMovieFragment()
            3 -> FavoriteShowFragment()
            else -> Fragment()
        }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence? =
        context.resources.getString(TAB_TITLES[position])
}