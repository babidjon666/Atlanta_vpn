package compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import atlanta_vpn.composeapp.generated.resources.Earth_gray
import atlanta_vpn.composeapp.generated.resources.Res
import atlanta_vpn.composeapp.generated.resources.phone_black
import atlanta_vpn.composeapp.generated.resources.phone_white
import org.jetbrains.compose.resources.painterResource
import ui.AtlantaColors
import utils.AtlantaText
import utils.CustomAtlantaButton

@Composable
fun RegionInfo(regionName: String) {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible.value = true
    }

    AnimatedVisibility(
        visible = visible.value,
        enter = fadeIn(animationSpec = tween(700, delayMillis = 900))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 27.dp)
                .fillMaxWidth()
                .height(83.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(AtlantaColors.LightGray3)
        ){
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 23.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Image(
//                    painter = painterResource(Res.drawable.phone_black),
//                    contentDescription = null,
//                    modifier = Modifier.height(38.dp).width(23.dp),
//                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    AtlantaText(
                        text = "Ваш регион",
                        weight = 400f,
                        size = 15f,
                        color = AtlantaColors.Gray
                    )
                    AtlantaText(
                        text = regionName,
                        weight = 510f,
                        size = 25f,
                        color = Color.Black
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(AtlantaColors.LightGray3),
                contentAlignment = Alignment.Center
            ){
                CustomAtlantaButton()
            }
        }
    }
}