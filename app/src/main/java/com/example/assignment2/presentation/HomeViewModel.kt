package com.example.TeamNN.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.TeamNN.data.Film

import com.example.TeamNN.data.UiState
import com.example.TeamNN.network.ApiService
import com.example.TeamNN.network.KinoApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel : ViewModel() {
    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    init {
        getFilms()
    }

    fun getFilms() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                UiState.Success(
                    categories = listOf(
                        KinoApi.retrofitService.getCollections("TOP_POPULAR_ALL",1).items,
                        KinoApi.retrofitService.getCollections("TOP_250_MOVIES",1).items
                    )
                )
            } catch (_: IOException) {
                UiState.Error
            } catch (_: HttpException) {
                UiState.Error
            }
        }
    }
}