package io.mmaltsev.vkeducation.presentation.applist

//Одноразовые события
sealed interface SquadListEvent {
    object ToolbarClicked : SquadListEvent
}