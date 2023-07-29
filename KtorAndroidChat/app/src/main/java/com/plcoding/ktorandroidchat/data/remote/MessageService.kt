package com.plcoding.ktorandroidchat.data.remote

import com.plcoding.ktorandroidchat.BuildConfig
import com.plcoding.ktorandroidchat.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "http://${BuildConfig.SERVER_IP}:8082"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages: Endpoints("$BASE_URL/messages")
    }
}