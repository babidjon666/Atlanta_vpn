package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun Memo(text: String?){
    Column(
        modifier = Modifier
            .height(90.dp)
            .width(188.dp)
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomEnd = 15.dp))
            .background(AtlantaColors.LightBlue),
    ) {
        Row(
            modifier = Modifier
                .height(16.dp)
                .width(104.dp)
                .padding(start = 9.dp, top = 7.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Black),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AtlantaText(
                text = "ВНИМАНИЕ: Памятка",
                weight = 700f,
                size = 7f,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(3.dp))

        Row(
            modifier = Modifier.padding(start = 9.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AtlantaText(
                text = "${text}",
                weight = 400f,
                size = 10f,
                color = Color.Black
            )
        }
    }
}