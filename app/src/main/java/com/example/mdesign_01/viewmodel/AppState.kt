package com.example.mdesign_01.viewmodel

import com.example.mdesign_01.model.PictureOfTheDayResponseData

sealed class AppState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData):AppState()
    data class Error(val error: Throwable):AppState()
    object Loading : AppState()
}