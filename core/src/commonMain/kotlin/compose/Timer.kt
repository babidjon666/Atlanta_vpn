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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import atlanta_vpn.composeapp.generated.resources.Earth_gray
import atlanta_vpn.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun Timer() {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible.value = true
    }

    AnimatedVisibility(
        visible = visible.value,
        enter = fadeIn(animationSpec = tween(700, delayMillis = 750))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 27.dp)
                .fillMaxWidth()
                .height(169.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AtlantaText(
                    text = "Вы не в сети",
                    weight = 400f,
                    size = 15f,
                    color = AtlantaColors.Gray
                )
                AtlantaText(
                    text = "0:00",
                    weight = 510f,
                    size = 45f,
                    color = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(7.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(35.dp))
                    .background(AtlantaColors.DarkGray),
                contentAlignment = Alignment.Center
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(21.dp)
                        .clip(CircleShape)
                        .background(AtlantaColors.Dark),
                    contentAlignment = Alignment.Center
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(7.dp)
                            .clip(CircleShape)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawCircle(
                                        color = AtlantaColors.LightGray,
                                        radius = size.minDimension / 2,
                                        style = Stroke(width = size.minDimension * 0.2f)
                                    )
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp)
                            .clip(CircleShape)
                            .background(Color.Black),
                        contentAlignment = Alignment.Center
                    ){
                        Image(
                            painter = painterResource(Res.drawable.Earth_gray),
                            contentDescription = null,
                            modifier = Modifier.size(29.dp),
                        )
                    }
                }
            }
        }
    }
}