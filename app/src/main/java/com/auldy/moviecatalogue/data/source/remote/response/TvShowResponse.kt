package com.auldy.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
@Parcelize
data class TvShowResponse(
    var tvshowid: String,
    var background: String,
    var poster: String,
    var title: String,
    var releasedate: String,
    var genre: String,
    var durasi: String,
    var average: String,
    var tagline: String,
    var overview: String,
    var status: String,
    var language: String,
    var budget: String,
    var revenue: String,
    var favoriteid: Boolean
) : Parcelable