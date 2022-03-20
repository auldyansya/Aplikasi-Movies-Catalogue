package com.auldy.moviecatalogue.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.ui.favorite.movies.FavoriteMoviesFragment
import com.auldy.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowFragment

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoritePagerAdapter(private val mContext: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshow)
    }
    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMoviesFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])

}