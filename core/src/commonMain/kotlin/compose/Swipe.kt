package compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.snapTo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import atlanta_vpn.composeapp.generated.resources.Arrow_swipe
import atlanta_vpn.composeapp.generated.resources.NoWIFI_white
import atlanta_vpn.composeapp.generated.resources.Res
import atlanta_vpn.composeapp.generated.resources.WIFI_White
import org.jetbrains.compose.resources.painterResource
import ui.AtlantaColors
import utils.AtlantaText
import kotlin.math.roundToInt

enum class SwipeAnchor { START, END }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Swipe(
    width: Dp,
    onSwipe: () -> Unit,
    onClick: () -> Unit,
    isSwiped: Boolean
) {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible.value = true
    }
    val haptic = LocalHapticFeedback.current

    val padding = 3.dp
    val parentPadding = 6.dp
    val parentWidth = width - 54.dp
    val parentHeight = 74.dp

    val boxWidth = 108.dp
    val boxHeight = 62.dp
    val parentBoxColor = if (isSwiped) {
        AtlantaColors.Blue.copy(alpha = 0.15f)
    } else {
        AtlantaColors.LightGrayForSwipe
    }

    val boxColor = if (isSwiped) {
        AtlantaColors.Blue
    } else {
        AtlantaColors.DarkGrayForSwipe
    }

    val density = LocalDensity.current
    val widthPx = with(density) { (parentWidth).toPx() }
    val state = remember {
        AnchoredDraggableState(
            initialValue = SwipeAnchor.START,
            anchors = DraggableAnchors {
                SwipeAnchor.START at 0f
                SwipeAnchor.END at widthPx * 2
            },
            positionalThreshold = { distance: Float -> distance },
            velocityThreshold = { with(density) { 1.dp.toPx() } },
            snapAnimationSpec = snap(),
            decayAnimationSpec = exponentialDecay()
        )
    }

    LaunchedEffect(state.currentValue) {
        if (state.currentValue == SwipeAnchor.END && !isSwiped) {
            haptic.performHapticFeedback(HapticFeedbackType.Confirm)
            onSwipe()
        }
    }

    LaunchedEffect(isSwiped) {
        if (!isSwiped) {
            state.snapTo(SwipeAnchor.START)
        }
    }

    AnimatedVisibility(
        visible = visible.value,
        enter = fadeIn(animationSpec = tween(700, delayMillis = 1050))
    ){
        Box(
            modifier = Modifier
                .height(parentHeight)
                .width(parentWidth)
                .clip(RoundedCornerShape(300.dp))
                .background(parentBoxColor)
                .padding(parentPadding),
            contentAlignment = Alignment.CenterStart
        ) {
            val dragOffset = (state.offset.roundToInt() / density.density).dp
            val calculatedWidth = (boxWidth + dragOffset).coerceAtLeast(boxWidth)
            val boxModifier = Modifier
                .anchoredDraggable(state, Orientation.Horizontal)
                .width(
                    if (isSwiped) {
                        parentWidth - parentPadding * 2
                    } else {
                        calculatedWidth
                    }
                )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val alignmentContent = if (isSwiped) {
                    Alignment.Center
                } else {
                    Alignment.CenterEnd
                }
                Box(
                    modifier = boxModifier
                        .padding(padding)
                        .clip(RoundedCornerShape(300.dp))
                        .background(boxColor).clickable {
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            onClick()
                        },
                    contentAlignment = alignmentContent
                ) {
                    Box(
                        modifier = Modifier
                            .height(boxHeight)
                            .then(if (isSwiped) Modifier else Modifier.width(boxWidth)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    if (isSwiped) {
                                        Res.drawable.WIFI_White
                                    } else {
                                        Res.drawable.NoWIFI_white
                                    }
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(18.dp)
                                    .width(22.dp),
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            AtlantaText(
                                text = if (isSwiped) {
                                    "Нажмите сюда, чтобы отключиться."
                                } else {
                                    "Не подключен"
                                },
                                weight = 510f,
                                size = 10f,
                                color = Color.White
                            )
                        }
                    }
                }

                if (!isSwiped) {
                    AnimatedVisibility(
                        visible = !(calculatedWidth > boxWidth),
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Spacer(modifier = Modifier.width(31.dp))
                        Image(
                            painter = painterResource(Res.drawable.Arrow_swipe),
                            contentDescription = null,
                            modifier = Modifier
                                .height(30.dp)
                                .width(127.dp),
                        )
                    }
                }
            }
        }
    }
}