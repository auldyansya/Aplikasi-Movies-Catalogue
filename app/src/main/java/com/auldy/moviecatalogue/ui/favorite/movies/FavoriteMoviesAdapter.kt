package com.auldy.moviecatalogue.ui.favorite.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.databinding.ItemsBinding
import com.auldy.moviecatalogue.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoriteMoviesAdapter (private val callback: FavoriteMoviesCallback):
    PagedListAdapter<MoviesEntity, FavoriteMoviesAdapter.FavoriteViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesEntity>() {

            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.moviesid == newItem.moviesid
            }

            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val favoriteAdapterBinding =
            ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(favoriteAdapterBinding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = getItem(position)
        if (favorite != null) {
            holder.bind(favorite)
        }
    }

    fun getSwipedData(swipedPosition: Int): MoviesEntity? = getItem(swipedPosition)

    inner class FavoriteViewHolder(private val binding: ItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                rvTitle.text = movies.title
                rvReleasedate.text = movies.releasedate
                rvAverage.text = movies.average
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIES, movies.moviesid)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(movies) }
                Glide.with(itemView.context)
                    .load(movies.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error)
                    )
                    .into(rvPoster)
            }
        }
    }
}