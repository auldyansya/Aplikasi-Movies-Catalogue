package com.auldy.moviecatalogue.ui.favorite.movies

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
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.databinding.FragmentFavoriteMoviesBinding
import com.auldy.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoriteMoviesFragment : Fragment(), FavoriteMoviesCallback {

    private var favoriteMoviesBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() =  favoriteMoviesBinding

    private lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter
    private lateinit var favoriteMoviesViewModel: FavoriteMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteMoviesBinding =
            FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFragmentmovies)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            favoriteMoviesViewModel =
                ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]

            favoriteMoviesAdapter = FavoriteMoviesAdapter(this)
            progressBar(true)
            favoriteMoviesViewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                progressBar(false)
                favoriteMoviesAdapter.submitList(movies)
            })

            with(binding?.rvFragmentmovies) {
                this?.layoutManager = GridLayoutManager(context, 2)
                this?.adapter = this@FavoriteMoviesFragment.favoriteMoviesAdapter
            }
        }
    }

    override fun onShareClick(movies: MoviesEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan Movies ini sekarang.")
                .setText("Segera Tonton Film ${movies.title} di Movie Catalogue versi Auldy")
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
                val moviesModel = favoriteMoviesAdapter.getSwipedData(swipedPosition)
                moviesModel?.let { favoriteMoviesViewModel.setFavoriteMovies(it) }

                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { _ ->
                    moviesModel?.let { favoriteMoviesViewModel.setFavoriteMovies(it) }
                }
                snackbar.show()
            }
        }

    })

    private fun progressBar(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
        }
    }
}