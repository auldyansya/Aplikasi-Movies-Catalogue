package com.auldy.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.auldy.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoriteTvShowFragment : Fragment(), FavoriteTvShowCallback {

    private var favoriteTvShowBinding : FragmentFavoriteTvShowBinding? = null
    private val binding get() = favoriteTvShowBinding
    private lateinit var favoriteTvShowAdapter: FavoriteTvShowAdapter
    private lateinit var favoriteTvShowViewModel: FavoriteTvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteTvShowBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFragmenttvshow)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            favoriteTvShowViewModel =
                ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            favoriteTvShowAdapter = FavoriteTvShowAdapter(this)
            progressBar(true)
            favoriteTvShowViewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
                progressBar(false)
                favoriteTvShowAdapter.submitList(tvShow)
            })

            with(binding?.rvFragmenttvshow) {
                this?.layoutManager = GridLayoutManager(context, 2)
                this?.adapter = this@FavoriteTvShowFragment.favoriteTvShowAdapter
            }
        }
    }

    override fun onShareClick(tvshow: TvShowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan Movies ini sekarang.")
                .setText("Segera Tonton Film ${tvshow.title} di Movie Catalogue versi Auldy")
                .startChooser()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowModel = favoriteTvShowAdapter.getSwipedData(swipedPosition)
                tvShowModel?.let { favoriteTvShowViewModel.setFavoriteTvShow(it) }

                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    tvShowModel?.let { favoriteTvShowViewModel.setFavoriteTvShow(it) }
                }
                snackbar.show()
            }
        }

    })


    private fun progressBar(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.INVISIBLE
        }
    }
}