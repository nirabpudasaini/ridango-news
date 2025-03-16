package com.pudasaini.ridangonews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.data.paging.NewsPagingSource
import com.pudasaini.ridangonews.data.remote.NewsApiService
import com.pudasaini.ridangonews.data.remote.SaveApiService
import com.pudasaini.ridangonews.data.utils.ProtoConverter.toProto
import com.pudasaini.ridangonews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Named

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApiService,
    @Named("saveApi") private val saveApi: SaveApiService
): NewsRepository {

    private val articlesCache = ConcurrentHashMap<String, ArticleDto>()

    override fun getTopHeadlines(): Flow<PagingData<ArticleDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 21,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { NewsPagingSource(newsApi, articlesCache)}
        ).flow
    }

    override suspend fun getArticleByUrl(url: String): ArticleDto? {
        return articlesCache[url]
    }

    override suspend fun saveArticle(article: ArticleDto) {
        // Since api is calling mock url this does not work currently
        // val respose = saveApi.saveArticle(article.toProto())
    }
}