package io.mmaltsev.vkeducation.domain.applist

import android.os.ParcelFileDescriptor

data class SquadInfo(
    val id: String,
    val emblem: Int,
    val name: String,
    val description: String,
    val direction: String
)