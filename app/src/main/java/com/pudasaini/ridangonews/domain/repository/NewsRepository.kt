package com.pudasaini.ridangonews.domain.repository

import androidx.paging.PagingData
import com.pudasaini.ridangonews.data.model.ArticleDto
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopHeadlines(): Flow<PagingData<ArticleDto>>
}