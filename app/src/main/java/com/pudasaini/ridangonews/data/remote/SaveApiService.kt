package com.pudasaini.ridangonews.data.remote

import com.pudasaini.ridangonews.proto.ArticleProto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SaveApiService {
    @POST("/v1/save-article")
    suspend fun saveArticle(
        @Body article: ArticleProto.Article
    ): Response<Unit>
}