package com.alwinsden.dino.botInterface.components.previews

import androidx.compose.runtime.Composable
import com.alwinsden.dino.botInterface.components.ModelDefinitions
import com.alwinsden.dino.botInterface.components.ModelSelectionParamDetails
import com.alwinsden.dino.botInterface.components.ModelSelectionRadioMenu
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

private class ModelSelectPreviewProvider : PreviewParameterProvider<ModelSelectionParamDetails> {
    override val values = sequenceOf(
        ModelSelectionParamDetails(
            name = "Google Gemini",
            description = "Advanced model from Google",
            incomingType = ModelDefinitions.GEMINI.name,
        ),
        ModelSelectionParamDetails(
            name = "Claude Opus",
            description = "Model from Anthropic",
            incomingType = ModelDefinitions.CLAUDE.name,
        ),
        ModelSelectionParamDetails(
            name = "Llama",
            description = "Experimental model from Meta",
            incomingType = ModelDefinitions.LLAMA.name,
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun ModelSelectionRadioMenuPreview(
    @PreviewParameter(ModelSelectPreviewProvider::class) incomingClass: ModelSelectionParamDetails
) {
    ModelSelectionRadioMenu(
        onClick = { tst ->

        },
        state = incomingClass,
        currentSelection = ModelDefinitions.CLAUDE.name
    )
}