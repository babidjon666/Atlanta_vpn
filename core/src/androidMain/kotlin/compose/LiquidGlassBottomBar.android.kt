package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.models.AppTabItem
import ui.AtlantaColors
import utils.AtlantaText

@Composable
actual fun LiquidGlassBottomBar(
    modifier: Modifier,
    tabs: List<AppTabItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(73.dp)
                .padding(start = 42.dp, end = 42.dp)
                .clip(RoundedCornerShape(300.dp))
                .background(AtlantaColors.GrayForNavBar),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, item ->
                NavigationBarItem(
                    iconName = item.iconName,
                    text = item.title,
                    isSelected = index == selectedIndex,
                    onClick = { onSelect(index) }
                )
            }
        }
    }
}

@Composable
private fun NavigationBarItem(
    iconName: String,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() },
    ) {
        AtlantaText(
            text = text,
            weight = 500f,
            size = 10f,
            color = Color.Black
        )
    }
}