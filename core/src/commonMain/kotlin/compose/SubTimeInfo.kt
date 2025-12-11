package compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import atlanta_vpn.composeapp.generated.resources.Res
import atlanta_vpn.composeapp.generated.resources.phone_black
import atlanta_vpn.composeapp.generated.resources.timer
import org.jetbrains.compose.resources.painterResource
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun SubTimeInfo(time: String){
    Row(modifier = Modifier
        .height(35.dp)
        .clip(RoundedCornerShape(300.dp))
        .background(AtlantaColors.LightBlue)
        .padding(horizontal = 7.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Image(
            painter = painterResource(Res.drawable.timer),
            contentDescription = null,
            modifier = Modifier.height(15.dp).width(12.dp),
        )

        Spacer(modifier = Modifier.width(6.dp))
        
        AtlantaText(
            text = "Истекает ${time}",
            weight = 400f,
            size = 10f,
            color = AtlantaColors.Gray3
        )
    }
}