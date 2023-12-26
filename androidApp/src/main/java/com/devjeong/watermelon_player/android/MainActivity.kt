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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "lazyColumnSample") {
                        composable("lazyColumnSample") { LazyColumnSample(navController) }
                        composable("detailScreen") { DetailScreen(navController) }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {
    val isLike = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Top App Bar
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White,
                navigationIconContentColor = Color.White
            ),
            title = {
                Text(
                    "재생중인 곡"
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )

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
                    text = "dsagdsagads",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF)
                    )
                )

                Text(
                    text = "gsgggggg",
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
                .background(Color.LightGray) // 배경 색상 설정
                .height(4.dp) // 높이 조절
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
fun CustomProgressBar(progress: Float) {
    val progressBarHeight = 4.dp
    val circleRadius = 8.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(circleRadius * 2)
            .background(Color(0xFF252932))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val barWidth = size.width
            val barHeight = progressBarHeight.toPx()
            val radius = circleRadius.toPx()

            // 진행 표시줄 그리기
            drawRect(
                color = Color(0xFFCAFB5C),
                size = Size(barWidth * progress, barHeight)
            )

            // 진행 표시줄 끝에 원 그리기
            if (progress > 0) {
                drawCircle(
                    color = Color(0xFFCAFB5C),
                    radius = radius,
                    center = Offset(barWidth * progress, size.height / 2)
                )
            }
        }
    }
}

@Composable
fun MusicControlButtons() {
    val isPlaying = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 반복 재생 버튼
        IconButton(onClick = { /* 반복 재생 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.repeat),
                contentDescription = "반복 재생",
                tint = Color.White
            )
        }

        // 이전 노래 버튼
        IconButton(onClick = { /* 이전 노래 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.skip_previous),
                contentDescription = "이전 노래",
                tint = Color.White
            )
        }

        Box(
            modifier = Modifier
                .border(
                    width = 1.dp, color = Color(0x33000000),
                    shape = RoundedCornerShape(size = 26.dp)
                )
                .width(80.dp)
                .height(80.dp)
                .background(
                    color = Color(0xFF222222),
                    shape = RoundedCornerShape(size = 26.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { isPlaying.value = !isPlaying.value }) {
                Icon(
                    painter =
                    if (isPlaying.value)
                        painterResource(id = R.drawable.pause)
                    else
                        painterResource(id = R.drawable.play),
                    contentDescription = if (isPlaying.value) "일시정지" else "재생",
                    tint = Color.White
                )
            }
        }

        // 다음 노래 버튼
        IconButton(onClick = { /* 다음 노래 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.skip_next),
                contentDescription = "다음 노래",
                tint = Color.White
            )
        }

        // 셔플 버튼
        IconButton(onClick = { /* 셔플 동작 */ }) {
            Icon(
                painter = painterResource(id = R.drawable.shuffle),
                contentDescription = "셔플",
                tint = Color.White
            )
        }
    }
}


@Composable
fun MediaPlayerUI(progress: Float, currentTime: String, totalTime: String) {
    CustomProgressBar(progress = progress)
}

@Composable
fun LazyColumnSample(navController: NavController) {
    // 여기에 표시할 데이터 리스트를 정의합니다.
    val dataList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    LazyColumn {
        items(items = dataList) { item ->
            ItemView(navController = navController, item = item)
        }
    }
}

@Composable
fun ItemView(navController: NavController, item: String) {
    Box(
        modifier = Modifier
            .clickable {
                navController.navigate("detailScreen")
            }
            .padding(horizontal = 23.dp)
            .padding(vertical = 12.dp)
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .border(
                width = 1.dp,
                color = Color(0x33000000),
                shape = RoundedCornerShape(25.dp)
            )
            .width(344.dp)
            .height(100.dp)
            .background(
                color = Color(0xFF222222),
                shape = RoundedCornerShape(25.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 이미지 박스와 텍스트 컬럼
            ImageAndTextColumn(item)
        }
    }
}

@Composable
fun ImageAndTextColumn(item: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // 이미지 박스
        Box(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
                .background(
                    color = Color(0xFFD9D9D9),
                    shape = RoundedCornerShape(18.dp)
                )
        )

        Spacer(Modifier.width(16.dp)) // 이미지 박스와 텍스트 사이의 간격

        Column {
            // 첫 번째 텍스트
            Text(
                text = item,
                modifier = Modifier
                    .widthIn(max = 180.dp)
                    .heightIn(max = 24.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF)
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // 두 번째 텍스트
            Text(
                text = "RoyaltyFreeMusic",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF999999)
                )
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MediaPlayerUI(0.1f, "0:33", "03:21")
    }
}
