package com.auldy.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.databinding.ItemsBinding
import com.auldy.moviecatalogue.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class TvShowAdapter (private val callback: TvShowCallback):
    PagedListAdapter<TvShowEntity,TvShowAdapter.TVShowViewHolder>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {

            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvshowid == newItem.tvshowid
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val tvShowAdapterBinding =
            ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(tvShowAdapterBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null)
            holder.bind(tvshow)
    }


    inner class TVShowViewHolder(private val binding: ItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvShowEntity) {
            with(binding) {
                rvTitle.text = tvshow.title
                rvReleasedate.text = tvshow.releasedate
                rvAverage.text = tvshow.average
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TVSHOW, tvshow.tvshowid)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvshow) }
                Glide.with(itemView.context)
                    .load(tvshow.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_error)
                            .error(R.drawable.ic_error)
                    )
                    .into(rvPoster)
            }
        }
    }
}