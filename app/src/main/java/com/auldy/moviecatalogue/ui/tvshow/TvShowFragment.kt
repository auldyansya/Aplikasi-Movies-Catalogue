package com.auldy.moviecatalogue.ui.tvshow

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
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.databinding.FragmentTvShowBinding
import com.auldy.moviecatalogue.viewmodel.ViewModelFactory
import com.auldy.moviecatalogue.vo.Status

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class TvShowFragment : Fragment(), TvShowCallback {

    private var fragmenTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = fragmenTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmenTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvshowAdapter = TvShowAdapter(this)
            tvShowViewModel.getTvShow().observe(viewLifecycleOwner, { tvshow ->
                if (tvshow != null) {
                    when (tvshow.status) {
                        Status.LOADING -> progressBar(true)
                        Status.SUCCESS -> {
                            progressBar(false)
                            tvshowAdapter.submitList(tvshow.data)
                            tvshowAdapter.notifyDataSetChanged()
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
            with(binding?.rvTvshow) {
                this?.layoutManager = GridLayoutManager(context, 2)
                this?.setHasFixedSize(true)
                this?.adapter = tvshowAdapter
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

    private fun progressBar(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
        }
    }
}