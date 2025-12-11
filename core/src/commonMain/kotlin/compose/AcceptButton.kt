package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun AcceptButton(onClick: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(59.dp)
            .padding(horizontal = 26.dp)
            .clip(RoundedCornerShape(300.dp))
            .background(AtlantaColors.Blue)
            .clickable{ onClick() },
        contentAlignment = Alignment.Center
    ){
        AtlantaText(
            text = "Активировать ключ",
            weight = 510f,
            size = 18f,
            color = Color.White
        )
    }
}