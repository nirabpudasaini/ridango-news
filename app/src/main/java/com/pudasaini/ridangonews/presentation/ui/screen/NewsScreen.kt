package com.pudasaini.ridangonews.presentation.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.presentation.ui.component.NewsItem
import com.pudasaini.ridangonews.presentation.ui.component.LoadingState
import com.pudasaini.ridangonews.presentation.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel(),
    onArticleClick: (ArticleDto) -> Unit
){
    val newsList = viewModel.newsFlow.collectAsLazyPagingItems()
    val configuration = LocalConfiguration.current

    val columns = when (configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> 3
        else -> 2
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Top Headlines") })}) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                count = newsList.itemCount,
                key = {index -> newsList[index]?.url ?: index}
            ) {
                index ->
                newsList[index]?.let{articleDto ->
                    NewsItem(
                        articleDto = articleDto,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { onArticleClick(articleDto) }
                    )
                }
            }

            item {
                if(newsList.loadState.append == LoadState.Loading){
                  LoadingState()
                }
            }
        }

    }
}