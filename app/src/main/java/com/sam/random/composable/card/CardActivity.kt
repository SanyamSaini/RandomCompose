package com.sam.random.composable.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.random.composable.R
import com.sam.random.composable.ui.theme.RandomComposableTheme

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomComposableTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    DisplayYouTubeVideos()
                }
            }
        }
    }
}

@Composable
fun DisplayYouTubeVideos() {
    val videosList = listOf(
        YoutubeData(R.drawable.jclogin, "Splash Screen in JetpackCompose", "Android Knowledge"),
        YoutubeData(R.drawable.jclogin, "Login Screen in JetpackCompose", "Android Knowledge"),
        YoutubeData(R.drawable.jclogin, "Nvigation Screen in JetpackCompose", "Android Knowledge"),
        YoutubeData(R.drawable.jclogin, "Bottom Navigation Screen in JetpackCompose", "Android Knowledge")
    )

    LazyColumn(modifier = Modifier.fillMaxHeight()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(videosList){video ->
            YouTubeUI(video)
        }

    }
}