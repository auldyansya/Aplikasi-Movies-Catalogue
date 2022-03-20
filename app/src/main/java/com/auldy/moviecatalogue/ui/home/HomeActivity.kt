package com.auldy.moviecatalogue.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.databinding.ActivityHomeBinding
import com.auldy.moviecatalogue.ui.favorite.FavoriteActivity
import com.auldy.moviecatalogue.ui.setting.SettingActivity

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class HomeActivity : AppCompatActivity() {

    private var homeBinding: ActivityHomeBinding? = null
    private val binding get() = homeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sectionsPagerAdapter = HomePagerAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)

        supportActionBar?.elevation = 0f
    }

    override fun onDestroy() {
        super.onDestroy()
        homeBinding = null
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