package io.mmaltsev.vkeducation.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SquadListViewModel  @Inject constructor(): ViewModel(){
    private val _state = MutableStateFlow(SquadListState(squads = squads))
    val state: StateFlow<SquadListState> = _state.asStateFlow()

    private val _events = Channel<SquadListEvent>(Channel.BUFFERED)
    val events: Flow<SquadListEvent> = _events.receiveAsFlow()

    fun onToolbarClick() {
        viewModelScope.launch {
            _events.send(SquadListEvent.ToolbarClicked)
        }
    }
}