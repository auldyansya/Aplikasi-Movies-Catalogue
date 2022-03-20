package com.auldy.moviecatalogue.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.data.source.local.entity.MoviesEntity
import com.auldy.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auldy.moviecatalogue.databinding.ActivityDetailBinding
import com.auldy.moviecatalogue.ui.favorite.FavoriteActivity
import com.auldy.moviecatalogue.ui.setting.SettingActivity
import com.auldy.moviecatalogue.viewmodel.ViewModelFactory
import com.auldy.moviecatalogue.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(detailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(EXTRA_MOVIES)
            if (moviesId != null) {
                detailViewModel.setSelectedMovies(moviesId)
                detailViewModel.movies.observe(this, { movies ->
                    when (movies.status) {
                        Status.LOADING -> progressBar(true)
                        Status.SUCCESS -> if (movies.data != null) {
                            progressBar(false)
                            dataDetailMovies(movies.data)
                        }
                        Status.ERROR -> {
                            progressBar(false)
                            Toast.makeText(
                                applicationContext,
                                resources.getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            }

            val tvshowId = extras.getString(EXTRA_TVSHOW)
            if (tvshowId != null) {
                detailViewModel.setSelectedTvShow(tvshowId)
                detailViewModel.tvShow.observe(this, { tvshow ->
                    when (tvshow.status) {
                        Status.LOADING -> progressBar(true)
                        Status.SUCCESS -> if (tvshow.data != null) {
                            progressBar(false)
                            dataDetailTvShow(tvshow.data)
                        }
                        Status.ERROR -> {
                            progressBar(false)
                            Toast.makeText(
                                applicationContext,
                                resources.getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })

            }
        }
    }

    private fun dataDetailMovies(moviesEntity: MoviesEntity) {
        var status = moviesEntity.favoriteid
        setFavorite(status)
        Glide.with(this)
            .load(moviesEntity.background)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.background)

        Glide.with(this)
            .load(moviesEntity.poster)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.poster)

        detailBinding.title.text = moviesEntity.title
        detailBinding.release.text = moviesEntity.releasedate
        detailBinding.durasi.text = moviesEntity.durasi
        detailBinding.genre.text = moviesEntity.genre
        detailBinding.average.text = moviesEntity.average
        detailBinding.tagline.text = moviesEntity.tagline
        detailBinding.overview.text = moviesEntity.overview
        detailBinding.status.text = resources.getString(R.string.status_a, moviesEntity.status)
        detailBinding.language.text = resources.getString(R.string.language_a, moviesEntity.language)
        detailBinding.budget.text = resources.getString(R.string.budget_a, moviesEntity.budget)
        detailBinding.revenue.text = resources.getString(R.string.revenue_a, moviesEntity.revenue)


        detailBinding.btnFavorite.setOnClickListener {
            status = !status
            setFavorite(status)
           detailViewModel.setFavorite()
        }
    }

    private fun dataDetailTvShow(tvShowEntity: TvShowEntity) {
        var status = tvShowEntity.favoriteid
        setFavorite(status)
        Glide.with(this)
            .load(tvShowEntity.background)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.background)

        Glide.with(this)
            .load(tvShowEntity.poster)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.poster)

        detailBinding.title.text = tvShowEntity.title
        detailBinding.release.text = tvShowEntity.releasedate
        detailBinding.durasi.text = tvShowEntity.durasi
        detailBinding.genre.text = tvShowEntity.genre
        detailBinding.average.text = tvShowEntity.average
        detailBinding.tagline.text = tvShowEntity.tagline
        detailBinding.overview.text = tvShowEntity.overview
        detailBinding.status.text = resources.getString(R.string.status_a, tvShowEntity.status)
        detailBinding.language.text = resources.getString(R.string.language_a, tvShowEntity.language)
        detailBinding.budget.text = resources.getString(R.string.budget_a, tvShowEntity.budget)
        detailBinding.revenue.text = resources.getString(R.string.revenue_a, tvShowEntity.revenue)


        detailBinding.btnFavorite.setOnClickListener {
            status = !status
            setFavorite(status)
            detailViewModel.setFavorite()
        }
    }


    private fun progressBar(state: Boolean) {
        if (state) {
            detailBinding.progressBar.visibility = View.VISIBLE
        } else {
            detailBinding.progressBar.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setFavorite(state: Boolean) {
        if (state) {
            detailBinding.btnFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            detailBinding.btnFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border
                )
            )
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int){
        when(selectedMode){
            R.id.favorite -> {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
            }
            R.id.setting -> {
                val moveSetting = Intent(this, SettingActivity::class.java)
                startActivity(moveSetting)
            }
        }
    }

}