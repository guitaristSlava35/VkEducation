package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.domain.applist.SquadInfo

fun SquadDto.toDomain(): SquadInfo = SquadInfo(
    id = id,
    emblem = emblemRes,
    name = name,
    description = description,
    direction = directionWork,
)