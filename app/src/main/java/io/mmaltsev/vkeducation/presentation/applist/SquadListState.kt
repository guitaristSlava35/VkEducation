package io.mmaltsev.vkeducation.presentation.applist

//Состояние экрана: всё что нужно для отрисовки
data class SquadListState(
    val squads: List<SquadInfo> = emptyList(),
)