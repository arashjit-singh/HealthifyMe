package com.healthifyme.ui.screens.onboarding.goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.healthifyme.data.local.DefaultSharedPreferences
import com.healthifyme.domain.Goal
import com.healthifyme.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(private val sharedPreferences: DefaultSharedPreferences) :
    ViewModel() {

    var userGoal by mutableStateOf<Goal>(sharedPreferences.getUserGoal())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun updateUserGoal(goal: Goal) {
        userGoal = goal
        sharedPreferences.saveUserGoal(goal)
    }

    fun navigateUser() {
        viewModelScope.launch {
            _uiEvent.send(UiEvent.NavigateUser)
        }
    }


}