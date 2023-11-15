package dev.cardoso.test.data.repositories

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import dev.cardoso.test.core.NetworkUtils
import dev.cardoso.test.data.remote.QuoteApi
import dev.cardoso.test.domain.repositories.QuoteRepository
import dev.cardoso.test.model.QuoteModel
import org.json.JSONArray
import retrofit2.Response
import javax.inject.Inject


class QuoteRepositoryImpl @Inject constructor (private val quoteApi : QuoteApi): QuoteRepository {
    override suspend fun getQuotes(): List<QuoteModel> {
        val json =  quoteApi.getQuotes(NetworkUtils.BASE_URL + "/")
        val item = object : TypeToken<List<QuoteModel>>() {}.type
        val quotes = Gson().fromJson<List<QuoteModel>>(json, item)
        return  quotes
    }

}