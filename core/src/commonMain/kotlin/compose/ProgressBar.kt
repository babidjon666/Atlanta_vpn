package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ui.AtlantaColors

@Composable
fun ProgressBar(
    isStatic: Boolean,
    usedValue: String,
    maxValue: String,
){
    if (isStatic){
        Box(
            modifier = Modifier
                .padding(horizontal = 21.dp)
                .height(13.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(300.dp))
                .background(AtlantaColors.Blue)
        )
    } else {
        fun parseValue(value: String): Float {
            val cleaned = value.replace(",", ".").trim()
            return when {
                cleaned.endsWith("Gib", ignoreCase = true) -> cleaned.dropLast(3).toFloat() * 1024
                cleaned.endsWith("Mib", ignoreCase = true) -> cleaned.dropLast(3).toFloat()
                cleaned.endsWith("Kib", ignoreCase = true) -> cleaned.dropLast(3).toFloat() / 1024
                else -> cleaned.toFloatOrNull() ?: 0f
            }
        }

        val used = parseValue(usedValue)
        val max = parseValue(maxValue).coerceAtLeast(1f)
        val progress = (used / max).coerceIn(0f, 1f)

        Box(
            modifier = Modifier
                .padding(horizontal = 21.dp)
                .height(13.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(300.dp))
                .background(AtlantaColors.Blue.copy(alpha = 0.4f))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress)
                    .clip(RoundedCornerShape(300.dp))
                    .background(AtlantaColors.Blue)
            )
        }
    }
}