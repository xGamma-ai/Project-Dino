package com.alwinsden.dino.botInterface.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alwinsden.dino.utilities.UI.DefaultFontStylesDataClass
import com.alwinsden.dino.utilities.UI.PageDefaults
import com.alwinsden.dino.utilities.UI.defaultFontStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BotTextField(mode: String? = null) {
    val defaultFieldText = "Talk to Dino.....a great listener."
    val defaultTextFieldValue = rememberTextFieldState("")
    if ((mode === null || mode == PageDefaults.botTextDefault)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(shape = RoundedCornerShape(100.dp))
                .border(shape = RoundedCornerShape(100.dp), color = Color.Transparent, width = 1.dp)
                .background(color = Color(0xffF2F2F2))
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(imageVector = Icons.Default.Image, contentDescription = "Attach images", tint = Color(0xff828282))
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier.weight(1f)
            ) {
                BasicTextField(
                    state = defaultTextFieldValue,
                    textStyle = defaultFontStyle(
                        DefaultFontStylesDataClass(
                            colorInt = 0xff000000,
                        )
                    ),
                )
                if (defaultTextFieldValue.text.toString().isEmpty()) {
                    Text(
                        text = defaultFieldText,
                        style = defaultFontStyle(
                            DefaultFontStylesDataClass(
                                colorInt = 0xff958282,
                            )
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Icon(imageVector = Icons.Default.Send, contentDescription = "Send query", tint = Color(0xff888888))
        }
    }
}
