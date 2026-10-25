package io.mmaltsev.vkeducation.data.applist

import io.mmaltsev.vkeducation.R
import javax.inject.Inject

// Источник данных: здесь живёт весь хардкод
class SquadsLocalDataSource @Inject constructor() {

    fun getSquads(): List<SquadDto> = listOf(
        SquadDto(
            id = "altair",
            emblemRes = R.drawable.ic_altair,
            name = "Альтаир",
            description = "Студенческий отряд направления ССервО",
            directionWork = "ССервО",
        ),
        SquadDto(
            id = "artifex",
            emblemRes = R.drawable.ic_artifex,
            name = "Артифекс",
            description = "Студенческий отряд направления САО",
            directionWork = "САО",
        ),
        SquadDto(
            id = "django",
            emblemRes = R.drawable.ic_django,
            name = "Джанго",
            description = "Студенческий отряд направления ССхО",
            directionWork = "ССхО",
        ),
        SquadDto(
            id = "legenda",
            emblemRes = R.drawable.ic_legenda,
            name = "Легенда",
            description = "Студенческий отряд направления СПО",
            directionWork = "СПО",
        ),
        SquadDto(
            id = "los",
            emblemRes = R.drawable.ic_los,
            name = "Лось",
            description = "Студенческий отряд направления ССхО",
            directionWork = "ССхО",
        ),
        SquadDto(
            id = "plamya",
            emblemRes = R.drawable.ic_plamya,
            name = "Пламя",
            description = "Студенческий отряд направления ССО",
            directionWork = "ССО",
        ),
        SquadDto(
            id = "provorniy",
            emblemRes = R.drawable.ic_provorniy,
            name = "Проворный",
            description = "Студенческий отряд направления СОП",
            directionWork = "СОП",
        ),
        SquadDto(
            id = "svarog",
            emblemRes = R.drawable.ic_svarog,
            name = "Сварог",
            description = "Студенческий отряд направления СПрО",
            directionWork = "СПрО",
        ),
    )
}