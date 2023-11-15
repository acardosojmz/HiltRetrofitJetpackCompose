package dev.cardoso.test.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.test.TestApp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: TestApp): Context {
        return application.applicationContext
    }

}