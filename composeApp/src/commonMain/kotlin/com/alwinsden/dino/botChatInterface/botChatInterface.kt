package com.alwinsden.dino.botChatInterface

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alwinsden.dino.botChatInterface.components.AiUpdatedField
import com.alwinsden.dino.botChatInterface.components.UserCreatedField
import com.alwinsden.dino.utilities.UI.DefaultFontStylesDataClass
import com.alwinsden.dino.utilities.UI.defaultFontStyle

@Composable
fun BotChatInterface() {
    BoxWithConstraints(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        val mxWidth = maxWidth * .7f
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.weight(1f, true))
            Text(
                text = "17th January 2026", textAlign = TextAlign.Center, style = defaultFontStyle(
                    DefaultFontStylesDataClass()
                )
            )
            Row(
                modifier = Modifier.weight(1f, true),
                horizontalArrangement = Arrangement.End,
            ) {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.PowerSettingsNew, contentDescription = "Logout app")
                }
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.History, contentDescription = "Logout app")
                }
            }
        }
        Column {
            Spacer(Modifier.height(50.dp))
            UserCreatedField(maxWidth = mxWidth)
            AiUpdatedField(maxWidth = mxWidth)
        }
    }
}