package utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.AtlantaColors

@Composable
fun CustomAtlantaButton(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp, top = 24.dp, start = 7.dp, end = 23.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(AtlantaColors.DarkGray2),
        contentAlignment = Alignment.Center
    ){
        AtlantaText(
            text = "Сменить регион",
            weight = 700f,
            size = 10f,
            color = Color.White
        )
    }
}