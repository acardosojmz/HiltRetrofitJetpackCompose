package dev.cardoso.test.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.test.data.repositories.QuoteRepositoryImpl
import dev.cardoso.test.domain.repositories.QuoteRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

}