package com.pudasaini.ridangonews.data.remote

import com.pudasaini.ridangonews.BuildConfig
import com.pudasaini.ridangonews.data.model.NewsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
     suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("pageSize") pageSize: Int = 21,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.NEWS_API_KEY
    ): NewsResponseDto
}