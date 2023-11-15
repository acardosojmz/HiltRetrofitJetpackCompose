package dev.cardoso.test.data.remote

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import dev.cardoso.test.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface QuoteApi {
        @GET
        suspend fun getQuotes(@Url url:String): JsonArray
    }
