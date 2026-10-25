package io.mmaltsev.vkeducation.presentation.applist

import io.mmaltsev.vkeducation.domain.applist.SquadInfo
//Состояние экрана: всё что нужно для отрисовки
data class SquadListState(
    val squads: List<SquadInfo> = emptyList(),
)