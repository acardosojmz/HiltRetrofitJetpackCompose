package dev.cardoso.test.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.cardoso.test.TestApp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ContextApplication {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): TestApp {
        return app as TestApp
    }
}