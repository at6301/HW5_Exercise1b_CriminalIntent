package com.thies.hw5_exercise1_criminalintent

import java.util.*

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)
