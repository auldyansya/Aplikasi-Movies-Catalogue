package com.auldy.moviecatalogue.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.databinding.ActivityFavoriteBinding
import com.auldy.moviecatalogue.ui.setting.SettingActivity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class FavoriteActivity : AppCompatActivity() {

    private lateinit var favoriteBinding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        val sectionsPagerAdapter = FavoritePagerAdapter(this, supportFragmentManager)
        favoriteBinding.viewPager.adapter = sectionsPagerAdapter
        favoriteBinding.tabsFavorite.setupWithViewPager(favoriteBinding.viewPager)
        supportActionBar?.title =
            applicationContext.resources.getString(R.string.favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
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