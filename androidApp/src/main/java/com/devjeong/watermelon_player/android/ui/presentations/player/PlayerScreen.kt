package com.devjeong.watermelon_player.android.ui.presentations.player

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.devjeong.watermelon_player.android.extensions.convertToText
import com.devjeong.watermelon_player.android.ui.presentations.player.components.ContentImage
import com.devjeong.watermelon_player.android.ui.presentations.player.components.CurrentTimeTextField
import com.devjeong.watermelon_player.android.ui.presentations.player.components.CustomTopAppBar
import com.devjeong.watermelon_player.android.ui.presentations.player.components.LikeButton
import com.devjeong.watermelon_player.android.ui.presentations.player.components.MusicControlButtons
import com.devjeong.watermelon_player.android.ui.presentations.player.components.SongInfo
import com.devjeong.watermelon_player.android.ui.presentations.player.components.TrackSlider
import com.devjeong.watermelon_player.android.ui.presentations.playlist.PlayListViewModel
import kotlinx.coroutines.delay

@Composable
fun PlayerScreen(
    navController: NavController,
    playListViewModel: PlayListViewModel,
    musicId: Int,
    playViewModel: PlayViewModel
) {
    val context = LocalContext.current
    val window = (context as Activity).window

    val currentSongId = remember { mutableIntStateOf(musicId) }

    // TEST;
    val currentPosition = remember { mutableLongStateOf(0) }

    val isPlaying = remember { mutableStateOf(false) }

    val sliderPosition = remember { mutableLongStateOf(0) }

    val totalDuration = remember { mutableLongStateOf(0) }

    val music = playListViewModel.musicListViewModel.findMusicById(currentSongId.intValue)

    LaunchedEffect(currentSongId.intValue) {
        playViewModel.playNewSong(currentSongId.intValue)
    }

    LaunchedEffect(
        key1 = playViewModel.playerUtil.commonMusicPlayer.currentPosition(),
        key2 = playViewModel.playerUtil.commonMusicPlayer.isPlaying()
    ) {
        delay(1000)
        currentPosition.longValue = playViewModel.playerUtil.commonMusicPlayer.currentPosition()
    }

    LaunchedEffect(currentPosition.longValue) {
        sliderPosition.longValue = currentPosition.longValue
    }


    SideEffect {
        window.statusBarColor = Color(0xFF151515).toArgb()
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = false
    }

    LaunchedEffect(playViewModel.playerUtil.commonMusicPlayer.duration()) {
        if (playViewModel.playerUtil.commonMusicPlayer.duration() > 0) {
            totalDuration.longValue = playViewModel.playerUtil.commonMusicPlayer.duration()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        CustomTopAppBar(navController)

        ContentImage(imageResId = music!!.imgUrl)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SongInfo(title = music.title, artist = music.artists)
            LikeButton(
                initialIsLiked = music.like,
                onClick = { _ ->
                    playListViewModel.musicListViewModel.toggleMusicLike(music.id)
                }
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
                .height(4.dp)
        ) {

            TrackSlider(
                value = sliderPosition.longValue.toFloat(),
                onValueChange = {
                    sliderPosition.longValue = it.toLong()
                },
                onValueChangeFinished = {
                    currentPosition.longValue = sliderPosition.longValue
                    playViewModel.playerUtil.commonMusicPlayer.seekTo(sliderPosition.longValue)
                },
                songDuration = totalDuration.longValue.toFloat()
            )


//            CustomProgressBar(0.5f, "0:33", music.duration)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val remainTime = totalDuration.longValue - currentPosition.longValue

            CurrentTimeTextField(
                (currentPosition.longValue).convertToText(),
                if (remainTime >= 0) remainTime.convertToText() else ""
            )
        }
        MusicControlButtons(
            playListViewModel,
            playViewModel,
            currentSongId,
            isPlaying
        )
    }
}