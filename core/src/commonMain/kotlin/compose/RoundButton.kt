package compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import atlanta_vpn.composeapp.generated.resources.Res
import atlanta_vpn.composeapp.generated.resources.timer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun RoundButton(
    color: Color,
    icon: DrawableResource,
    iconWidth: Dp,
    iconHeight: Dp,
    isNeedPadding: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(color)
            .padding(end = (if (isNeedPadding) 3.dp else 0.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.height(iconHeight).width(iconWidth),
        )
    }
}
