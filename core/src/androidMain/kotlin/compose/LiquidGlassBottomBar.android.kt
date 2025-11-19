package compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.models.AppTabItem

@Composable
actual fun LiquidGlassBottomBar(
    modifier: Modifier,
    tabs: List<AppTabItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit
) {
    Text("Бар для андроида")
}