package com.pudasaini.ridangonews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.pudasaini.ridangonews.presentation.NewsAppNavigation
import com.pudasaini.ridangonews.presentation.ui.screen.NewsScreen
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
                NewsAppNavigation()
            }
        }
    }
}
