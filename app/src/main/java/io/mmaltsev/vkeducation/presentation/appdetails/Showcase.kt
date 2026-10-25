package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.domain.applist.SquadInfo
import io.mmaltsev.vkeducation.presentation.applist.SquadListItem
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

private const val APPS_PER_PAGE = 3

// Блок «Витрина»: заголовок + горизонтальный постраничный список (3 страницы по 3 приложения)
@Composable
fun Showcase(
    apps: List<SquadInfo>,
    onAppClick: (SquadInfo) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pages = apps.chunked(APPS_PER_PAGE)
    val pagerState = rememberPagerState { pages.size }

    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_showcase),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(8.dp))
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 8.dp,
            verticalAlignment = Alignment.Top,
        ) { pageIndex ->
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                pages[pageIndex].forEach { app ->
                    SquadListItem(
                        squad = app,
                        onClick = { onAppClick(app) },
                    )
                }
            }
        }
    }
}

// Данные «Витрины» пока остаются здесь (в этом задании переносим только список приложений)
val showcaseApps = listOf(
    SquadInfo("s1", R.drawable.ic_altair, "Альтаир", "Студенческий отряд направления ССервО", "ССервО"),
    SquadInfo("s2", R.drawable.ic_artifex, "Артифекс", "Студенческий отряд направления САО", "САО"),
    SquadInfo("s3", R.drawable.ic_django, "Джанго", "Студенческий отряд направления ССхО", "ССхО"),
    SquadInfo("s4", R.drawable.ic_legenda, "Легенда", "Студенческий отряд направления СПО", "СПО"),
    SquadInfo("s5", R.drawable.ic_los, "Лось", "Студенческий отряд направления ССхО", "ССхО"),
    SquadInfo("s6", R.drawable.ic_plamya, "Пламя", "Студенческий отряд направления ССО", "ССО"),
    SquadInfo("s7", R.drawable.ic_provorniy, "Проворный", "Студенческий отряд направления СОП", "СОП"),
    SquadInfo("s8", R.drawable.ic_svarog, "Сварог", "Студенческий отряд направления СПрО", "СПрО"),
    // TODO: девятому приложению нужна своя эмблема, пока повтор ic_altair
    SquadInfo("s9", R.drawable.ic_orion, "Орион", "Студенческий отряд направления ССО", "ССО"),
)

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        Showcase(
            apps = showcaseApps,
            onAppClick = {},
        )
    }
}