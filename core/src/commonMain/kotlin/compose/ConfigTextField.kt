package compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.AtlantaColors
import utils.AtlantaText

@Composable
fun ConfigTextField(
    configUrl: String,
    onValueChange: (String) -> Unit
){
    var textFieldValue by remember(configUrl) {
        mutableStateOf(TextFieldValue(text = configUrl))
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(59.dp)
        .padding(horizontal = 27.dp)
        .clip(RoundedCornerShape(50.dp))
        .background(AtlantaColors.LightGray2),
        contentAlignment = Alignment.Center
    ){
        BasicTextField(
            value = textFieldValue,
            modifier = Modifier
                .padding(horizontal = 29.dp, vertical = 21.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp,
            ),
            decorationBox = { innerTextField ->
                if (textFieldValue.text.isBlank()) {
                    AtlantaText(
                        text = "Вставьте ключ вашего VPN..",
                        weight = 400f,
                        size = 15f,
                        color = Color.Gray
                    )
                }
                innerTextField()
            },
            singleLine = true,
            onValueChange = { text ->
                textFieldValue = text
                onValueChange.invoke(textFieldValue.text)
            }
        )
    }
}