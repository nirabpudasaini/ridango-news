package com.pudasaini.ridangonews.di

import com.pudasaini.ridangonews.data.remote.NewsApiClient
import com.pudasaini.ridangonews.data.remote.NewsApiService
import com.pudasaini.ridangonews.data.remote.SaveApiService
import com.pudasaini.ridangonews.data.remote.SaveApiclient
import com.pudasaini.ridangonews.data.repository.NewsRepositoryImpl
import com.pudasaini.ridangonews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @Named("newsApi")
    fun provideNewsApi(): NewsApiService = NewsApiClient.newsApi

    @Provides
    @Singleton
    @Named("saveApi")
    fun provideSaveApi(): SaveApiService = SaveApiclient.saveApi

    @Provides
    @Singleton
    fun providesNewsRepository(
        @Named("newsApi")newsApi: NewsApiService,
        @Named("saveApi") saveApi: SaveApiService): NewsRepository = NewsRepositoryImpl(newsApi, saveApi)
}