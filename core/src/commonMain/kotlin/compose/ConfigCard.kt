package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import utils.AtlantaText

@Composable
fun ConfigCard(
    text: String,
    onClick: () -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(65.dp)
        .padding(horizontal = 21.dp)
        .padding(top = 10.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .padding(start = 23.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            AtlantaText(
                text = text,
                weight = 700f,
                size = 17f,
                color = Color.Black
            )
        }
    }
}