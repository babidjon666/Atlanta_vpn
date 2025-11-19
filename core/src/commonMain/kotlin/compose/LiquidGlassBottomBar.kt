package compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.models.AppTabItem

@Composable
expect fun LiquidGlassBottomBar(
    modifier: Modifier = Modifier,
    tabs: List<AppTabItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit
)
