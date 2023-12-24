package com.devjeong.watermelon_player.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devjeong.watermelon_player.Greeting
import com.devjeong.watermelon_player.android.music.presentation.MusicItemView
import com.devjeong.watermelon_player.audioplayer.presentation.MusicViewModel
import com.devjeong.watermelon_player.core.domain.util.Resource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //GreetingView(Greeting().greet())
                    MusicScreen()
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Composable
fun MusicScreen() {
    val musicViewModel: MusicViewModel = viewModel()
    val musicState by musicViewModel.state.collectAsState()

    when (val state = musicState) {
        is Resource.Loading -> LoadingView()
        is Resource.Success -> MusicListView(state.data ?: emptyList())
        is Resource.Error -> ErrorView(state.throwable)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
