package io.mmaltsev.vkeducation.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.mmaltsev.vkeducation.domain.applist.GetSquadsUseCase
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SquadListViewModel @Inject constructor(
    private val getSquads: GetSquadsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(SquadListState())
    val state: StateFlow<SquadListState> = _state.asStateFlow()

    private val _events = Channel<SquadListEvent>(Channel.BUFFERED)
    val events: Flow<SquadListEvent> = _events.receiveAsFlow()

    init {
        loadSquads()
    }

    // Данные приходят из domain (UseCase -> Repository -> DataSource), а не из хардкода во ViewModel
    private fun loadSquads() {
        viewModelScope.launch {
            _state.value = SquadListState(squads = getSquads())
        }
    }

    fun onToolbarClick() {
        viewModelScope.launch {
            _events.send(SquadListEvent.ToolbarClicked)
        }
    }
}