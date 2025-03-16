package com.pudasaini.ridangonews.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pudasaini.ridangonews.presentation.ui.screen.ArticleDetailScreen
import com.pudasaini.ridangonews.presentation.ui.screen.NewsScreen
import com.pudasaini.ridangonews.presentation.viewmodel.NewsViewModel
import java.net.URLDecoder
import java.net.URLEncoder

@Composable
fun NewsAppNavigation(){
    val navController = rememberNavController()
    val viewModel : NewsViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "news" ){
        composable("news") {
            NewsScreen { article ->
                navController.navigate("details/${article.url.encodeURL()}")
            }
        }
        composable(
            route = "details/{url}",
            arguments = listOf(navArgument("url"){type = NavType.StringType})
            ) { backStackEntry ->
            val articleUrl = backStackEntry.arguments?.getString("url")?.decodeURL()
            val article = remember(articleUrl) {articleUrl?.let { viewModel.getArticleByUrl(it) }
            }
            article?.let {
                ArticleDetailScreen(
                    article = it,
                    onSaveClick = { viewModel.saveArticle(article) },
                    onBack = {navController.popBackStack()})
            }

        }
    }

}

// URL encoding/decoding extensions
fun String.encodeURL(): String = URLEncoder.encode(this, "UTF-8")
fun String.decodeURL(): String = URLDecoder.decode(this, "UTF-8")