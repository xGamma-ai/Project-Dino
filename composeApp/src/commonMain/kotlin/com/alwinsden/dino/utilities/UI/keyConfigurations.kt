package com.alwinsden.dino.utilities.UI

import com.alwinsden.dino.BuildKonfig
import com.alwinsden.dino.botInterface.components.ModelDefinitions
import com.alwinsden.dino.botInterface.components.ModelSelectionParamDetails
import com.alwinsden.dino.requestManager.IClientInterface

class ClientKtorConfiguration : IClientInterface {
    override val baseUrl: String = BuildKonfig.KTOR_ENTRY_URL
}

object Defaults {
    val default = "DEFAULT"
}

object PageDefaults {
    //BotTextField
    val botTextDefault = "INIT"
    val botTextExtend = "EXTEND"
}

val listModelDefinitions = listOf<ModelSelectionParamDetails>(
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