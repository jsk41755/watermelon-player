package com.devjeong.watermelon_player.presentaions

import com.devjeong.watermelon_player.presentations.MusicListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MusicListPresenter : KoinComponent {
    private val musicListViewModel: MusicListViewModel by inject()

}