package com.auldy.moviecatalogue.utils

import android.content.Context
import com.auldy.moviecatalogue.data.source.remote.response.MoviesResponse
import com.auldy.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MoviesResponse> {
        val list = ArrayList<MoviesResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("AssetMovies.json").toString())
            val listArray = responseObject.getJSONArray("assetmovies")
            for (i in 0..listArray.length()) {
                val movies = listArray.getJSONObject(i)

                with(movies) {
                    val id = getString("id")
                    val background = getString("background")
                    val poster = getString("poster")
                    val title = getString("title")
                    val releasedate = getString("releasedate")
                    val genre = getString("genre")
                    val durasi = getString("durasi")
                    val average = getString("average")
                    val tagline = getString("tagline")
                    val overview = getString("overview")
                    val status = getString("status")
                    val language = getString("language")
                    val budget = getString("budget")
                    val revenue = getString("revenue")

                    val moviesResponse = MoviesResponse(
                        id,
                        background,
                        poster,
                        title,
                        releasedate,
                        genre,
                        durasi,
                        average,
                        tagline,
                        overview,
                        status,
                        language,
                        budget,
                        revenue,
                        false
                    )
                    list.add(moviesResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("AssetTvShow.json").toString())
            val listArray = responseObject.getJSONArray("assettvshow")
            for (i in 0..listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                with(tvShow) {
                    val id = getString("id")
                    val background = getString("background")
                    val poster = getString("poster")
                    val title = getString("title")
                    val releasedate = getString("releasedate")
                    val genre = getString("genre")
                    val durasi = getString("durasi")
                    val average = getString("average")
                    val tagline = getString("tagline")
                    val overview = getString("overview")
                    val status = getString("status")
                    val language = getString("language")
                    val budget = getString("budget")
                    val revenue = getString("revenue")

                    val tvShowResponse = TvShowResponse(
                        id,
                        background,
                        poster,
                        title,
                        releasedate,
                        genre,
                        durasi,
                        average,
                        tagline,
                        overview,
                        status,
                        language,
                        budget,
                        revenue,
                        false
                    )
                    list.add(tvShowResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}