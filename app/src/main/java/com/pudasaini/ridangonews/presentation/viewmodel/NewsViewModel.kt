package com.pudasaini.ridangonews.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel(){
    val newsFlow = repository.getTopHeadlines().cachedIn(viewModelScope)

    fun getArticleByUrl(url: String): ArticleDto?{
        return runBlocking { repository.getArticleByUrl(url) }
    }

    fun saveArticle(article: ArticleDto){
        viewModelScope.launch {
            repository.saveArticle(article)
        }
    }
}