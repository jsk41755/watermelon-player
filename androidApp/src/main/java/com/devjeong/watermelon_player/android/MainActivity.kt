package com.devjeong.watermelon_player.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devjeong.watermelon_player.android.player.presentation.components.CustomTopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MusicRoot()
                }
            }
        }
    }
}

@Composable
fun MusicRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lazyColumnSample"
    ) {
        composable(
            "lazyColumnSample"
        ) {
            LazyColumnSample(navController)
        }
        composable(
            "detailScreen"
        ) {
            DetailScreen(navController)
        }
    }
}
@Composable
fun DetailScreen(navController: NavController) {
    val isLike = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CustomTopAppBar(navController)

        Image(
            painter = painterResource(
                id = R.drawable.rectangle_1332
            ),
            contentDescription = "Content Image",
            Modifier
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color(0x26000000),
                    ambientColor = Color(0x26000000)
                )
                .width(344.dp)
                .height(344.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Trap Future Bass",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF)
                    )
                )

                Text(
                    text = "RoyaltyFreeMusic",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF999999),
                    )
                )
            }
            IconButton(onClick = { isLike.value = !isLike.value }) {
                Image(
                    painter =
                    if (!isLike.value)
                        painterResource(id = R.drawable.un_activate_like)
                    else
                        painterResource(id = R.drawable.activate_like),
                    contentDescription = if (isLike.value) "일시정지" else "재생",
                    modifier = Modifier
                        .padding(0.dp)
                        .width(28.dp)
                        .height(28.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
                .height(4.dp)
        ) {
            MediaPlayerUI(0.5f, "0:33", "03:21")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "00:32",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                )
            )
            Text(
                text = "03:21",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Right,
                )
            )
        }

        MusicControlButtons()
    }
}
@Composable
fun MediaPlayerUI(progress: Float, currentTime: String, totalTime: String) {
    CustomProgressBar(progress = progress)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MediaPlayerUI(0.1f, "0:33", "03:21")
    }
}
