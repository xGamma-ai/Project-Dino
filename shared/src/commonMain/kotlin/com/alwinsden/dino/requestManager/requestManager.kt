package com.alwinsden.dino.requestManager

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class RequestManager(private val requestConfig: IClientInterface) {
    public val client = HttpClient() {
        defaultRequest {
            url(requestConfig.baseUrl)
        }
    }

    suspend fun healthCheck(): String {
        val response = client.get("/health")
        println(response.bodyAsText())
        return "OKAY"
    }
}