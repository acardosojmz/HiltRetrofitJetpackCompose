package dev.cardoso.test.domain.repositories

import dev.cardoso.test.model.QuoteModel
import retrofit2.Response

interface QuoteRepository {
    suspend fun getQuotes() : List<QuoteModel>
}

