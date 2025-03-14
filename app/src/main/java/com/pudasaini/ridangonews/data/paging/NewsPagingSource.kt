package com.pudasaini.ridangonews.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.data.remote.NewsApiService

class NewsPagingSource(
    private val newsApi: NewsApiService
) : PagingSource<Int, ArticleDto>(){
    override fun getRefreshKey(state: PagingState<Int, ArticleDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDto> {
        return try {
            val pageNumber = params.key ?: 1

            val response = newsApi.getTopHeadlines(
                pageSize = params.loadSize,
                page = pageNumber
            )

            LoadResult.Page(
                data = response.articles,
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (response.articles.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}