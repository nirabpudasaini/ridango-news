package com.pudasaini.ridangonews.domain.usecase

import androidx.paging.PagingData
import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopHeadlineUseCase @Inject constructor(
    private val repository:NewsRepository
) {
    operator fun invoke(): Flow<PagingData<ArticleDto>> {
        return repository.getTopHeadlines()
    }
}