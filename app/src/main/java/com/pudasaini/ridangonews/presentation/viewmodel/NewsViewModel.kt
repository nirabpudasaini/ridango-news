package com.pudasaini.ridangonews.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.pudasaini.ridangonews.domain.usecase.GetTopHeadlineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlineUseCase
) : ViewModel(){
    val newsFlow = getTopHeadlinesUseCase().cachedIn(viewModelScope)
}