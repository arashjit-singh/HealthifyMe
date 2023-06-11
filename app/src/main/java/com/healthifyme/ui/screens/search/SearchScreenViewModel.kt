package com.healthifyme.ui.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.healthifyme.data.remote.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(val searchRepository: SearchRepository) :
    ViewModel() {

    var state by mutableStateOf(SearchState())
        private set

    var userInput by mutableStateOf("")
        private set

    var shouldShowHint by mutableStateOf(userInput.isEmpty())
        private set

    fun onUserEnterValue(value: String) {
        userInput = value
        shouldShowHint = userInput.isEmpty()
    }

    fun searchFood() {
        Timber.i("Searching.. ${userInput}")
        viewModelScope.launch {

            state = state.copy(
                trackableFood = emptyList(),
                isSearching = true
            )

            searchRepository.searchFood(userInput, 1, 20).onSuccess { data ->
                state = state.copy(
                    trackableFood = data,
                    isSearching = false,
                    query = ""
                )
            }
        }
    }
}