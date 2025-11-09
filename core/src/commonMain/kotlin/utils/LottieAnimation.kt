package utils

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import atlanta_vpn.composeapp.generated.resources.Res
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LottieAnimation(
    jsonPath: String,
    isLoop: Boolean,
    modifier: Modifier = Modifier
) {
    var json by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        json = withContext(Dispatchers.IO) {
            Res.readBytes(jsonPath).decodeToString()
        }
    }
    if (json == null) return

    val composition by rememberLottieComposition(
        LottieCompositionSpec.JsonString(json!!)
    )

    val iterations = if (isLoop) Compottie.IterateForever else 1

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = iterations
    )

    Image(
        painter = rememberLottiePainter(
            composition = composition,
            progress = { progress },
        ),
        modifier = modifier,
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}