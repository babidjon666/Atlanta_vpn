package utils

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
actual fun AtlantaText(text: String, weight: Float, size: Float) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = FontFamily.Default, //  SF Pro
            fontWeight = mapWeight(weight),
            fontSize = size.sp,
            letterSpacing = (-0.45).sp
        )
    )
}
fun mapWeight(weight: Float): FontWeight =
    when {
        weight <= 300f -> FontWeight.Light
        weight <= 400f -> FontWeight.Normal
        weight <= 500f -> FontWeight.Medium
        weight <= 600f -> FontWeight.SemiBold
        else -> FontWeight.Bold
    }
