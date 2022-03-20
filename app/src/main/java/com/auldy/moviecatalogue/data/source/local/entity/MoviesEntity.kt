package com.auldy.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
@Entity(tableName = "moviesentities")
data class MoviesEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "moviesid")
    var moviesid: String,

    @ColumnInfo(name = "background")
    var background: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "releasedate")
    var releasedate: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "durasi")
    var durasi: String,

    @ColumnInfo(name = "average")
    var average: String,

    @ColumnInfo(name = "tagline")
    var tagline: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "language")
    var language: String,

    @ColumnInfo(name = "budget")
    var budget: String,

    @ColumnInfo(name = "revenue")
    var revenue: String,

    @ColumnInfo(name = "favoriteid")
    var favoriteid: Boolean = false
)

