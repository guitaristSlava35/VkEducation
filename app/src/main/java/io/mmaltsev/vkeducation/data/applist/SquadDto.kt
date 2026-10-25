package io.mmaltsev.vkeducation.data.applist

import androidx.annotation.DrawableRes

data class SquadDto(
    val id: String,
    @DrawableRes val emblemRes: Int,
    val name: String,
    val description: String,
    val directionWork: String,
)