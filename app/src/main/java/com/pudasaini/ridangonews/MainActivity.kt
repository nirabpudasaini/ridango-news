package com.pudasaini.ridangonews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.pudasaini.ridangonews.presentation.ui.theme.RidangoNewsTheme
import com.pudasaini.ridangonews.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RidangoNewsTheme {
                NewsListScreen(viewModel = viewModel)
            }
        }
    }

}


@Composable
fun NewsListScreen(viewModel: NewsViewModel) {
    val newsItems = viewModel.newsFlow.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(
            count = newsItems.itemCount,
            key = { index -> newsItems[index]?.url ?: index }
        ) { index ->
            newsItems[index]?.let { article ->
                Text(
                    text = article.title,
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        if (newsItems.loadState.refresh is LoadState.Error) {
            item {
                Text(
                    text = "Error loading news",
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}