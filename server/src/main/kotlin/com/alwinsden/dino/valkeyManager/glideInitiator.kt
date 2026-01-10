package com.alwinsden.dino.valkeyManager

import glide.api.GlideClient
import glide.api.models.configuration.GlideClientConfiguration
import glide.api.models.configuration.NodeAddress
import io.ktor.server.application.*
import kotlinx.coroutines.future.await

object ValkeyManager {
    private var client: GlideClient? = null
    suspend fun initValkey(environment: ApplicationEnvironment) {
        val host = environment.config.property("dinoBackend.valkeyConfig.VALKEY_HOST").getString()
        val port = environment.config.property("dinoBackend.valkeyConfig.VALKEY_PORT")
            .getString()
        val useSsl =
            environment.config.property("dinoBackend.valkeyConfig.VALKEY_USE_SSL")
                .getString().toBoolean()
        val config: GlideClientConfiguration = GlideClientConfiguration.builder()
            .address(
                NodeAddress.builder().host(host).port(port.toInt()).build()
            )
            .useTLS(useSsl)
            .requestTimeout(500)
            .build()
        client = GlideClient.createClient(config).await()
    }

    fun getClient(): GlideClient = client ?: throw IllegalStateException("GLIDE client not initialized.")
}