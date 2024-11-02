package com.example.TeamNN.data

sealed interface UiState{
    data class Success(val categories: List<List<Film>>): UiState
    object Error : UiState
    object Loading : UiState
}