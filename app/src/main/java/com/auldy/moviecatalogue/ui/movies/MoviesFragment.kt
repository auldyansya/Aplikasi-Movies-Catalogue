package com.auldy.moviecatalogue.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.databinding.FragmentMoviesBinding
import com.auldy.moviecatalogue.viewmodel.ViewModelFactory
import com.auldy.moviecatalogue.vo.Status

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class MoviesFragment : Fragment(), MoviesCallback {

    private var fragmentMoviesBinding: FragmentMoviesBinding? = null
    private val binding get() = fragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val moviesViewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter(this)
            moviesViewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> progressBar(true)
                        Status.SUCCESS -> {
                            progressBar(false)
                            moviesAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            progressBar(false)
                            Toast.makeText(
                                context,
                                resources.getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            })

            with(binding?.rvMovies) {
                this?.layoutManager = GridLayoutManager(context, 2)
                this?.setHasFixedSize(true)
                this?.adapter = moviesAdapter
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

    private fun progressBar(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMoviesBinding= null
    }
}