package com.andresaftari.submissionfinal.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieDetail(
    @Embedded
    var movie: Movie,

    @Relation(parentColumn = "movieId", entityColumn = "movieId")
    var details: Movie
)