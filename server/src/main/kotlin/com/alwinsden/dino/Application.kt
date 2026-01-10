package com.alwinsden.dino

import com.alwinsden.dino.googleAuthn.serverManager.nonceGenerator
import com.alwinsden.dino.googleAuthn.serverManager.verifyGoogleToken
import com.alwinsden.dino.valkeyManager.ValkeyManager
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.launch

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    launch {
        try {
            val applicationEnv: ApplicationEnvironment = environment
            ValkeyManager.apply { initValkey(applicationEnv) }
        } catch (e: Exception) {
            log.error("Failed to initialize ValkeyManager")
            e.printStackTrace()
        }
    }
    routing {
        //health check API
        get("/health") {
            application.log.debug("Triggered health check")
            call.respondText("Ktor is healthy.")
        }

        //generate nonce
        get("/generate-nonce") {
            val generatedNonce = call.nonceGenerator()
            call.respondText(generatedNonce)
        }

        //g-auth google verify
        post("/login") {
            val text = call.receiveText()
            call.verifyGoogleToken(text)
            call.respondText("return JTW token here")//TODO
        }
    }
}