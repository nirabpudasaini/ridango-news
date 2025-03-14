package com.pudasaini.ridangonews.di

import com.pudasaini.ridangonews.data.remote.NewsApiClient
import com.pudasaini.ridangonews.data.remote.NewsApiService
import com.pudasaini.ridangonews.data.repository.NewsRepositoryImpl
import com.pudasaini.ridangonews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApiService = NewsApiClient.newsApi

    @Provides
    @Singleton
    fun providesNewsRepository(api: NewsApiService): NewsRepository = NewsRepositoryImpl(api)
}