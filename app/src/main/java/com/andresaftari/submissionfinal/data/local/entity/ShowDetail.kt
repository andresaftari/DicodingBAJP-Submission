package com.andresaftari.submissionfinal.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ShowDetail(
    @Embedded
    var show: Show,

    @Relation(parentColumn = "showId", entityColumn = "showId")
    var details: Show
)