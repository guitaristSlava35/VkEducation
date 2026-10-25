package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme
import kotlinx.coroutines.flow.Flow

// Экран с ViewModel: берёт состояние, слушает события, передаёт всё в Content
@Composable
fun SquadListScreen(
    onAppClick: (SquadInfo) -> Unit,
    viewModel: SquadListViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = viewModel.events,
        snackbarHostState = snackbarHostState,
    )

    SquadListContent(
        state = state,
        snackbarHostState = snackbarHostState,
        onToolbarClick = viewModel::onToolbarClick,
        onAppClick = onAppClick,
    )
}

// «Глупый» экран: только рисует переданное состояние (удобно для Preview)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquadListContent(
    state: SquadListState,
    snackbarHostState: SnackbarHostState,
    onToolbarClick: () -> Unit,
    onAppClick: (SquadInfo) -> Unit,
) {
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Отряды СПб") },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(32.dp),
                        tint = Color.Unspecified,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                // Тулбар кликабельный: клик уходит во ViewModel
                modifier = Modifier.clickable(onClick = onToolbarClick),
            )
        },
    ) { padding ->
        SquadList(
            squads = state.squads,
            onAppClick = onAppClick,
            modifier = Modifier.padding(padding),
        )
    }
}

@Composable
fun SquadList(
    squads: List<SquadInfo>,
    onAppClick: (SquadInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(squads) { squad ->
            SquadListItem(
                squad = squad,
                onClick = { onAppClick(squad) },
            )
        }
    }
}

// Слушает одноразовые события из ViewModel и показывает снекбар
@Composable
private fun ObserveEvents(
    events: Flow<SquadListEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val toolbarMessage = stringResource(R.string.squad_list_toolbar_message)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is SquadListEvent.ToolbarClicked -> {
                    snackbarHostState.showSnackbar(toolbarMessage)
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        SquadListContent(
            state = SquadListState(squads = squads),
            snackbarHostState = remember { SnackbarHostState() },
            onToolbarClick = {},
            onAppClick = {},
        )
    }
}