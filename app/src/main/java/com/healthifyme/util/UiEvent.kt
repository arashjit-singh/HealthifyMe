package com.healthifyme.util

sealed class UiEvent {
    object NavigateUser : UiEvent()
    data class ShowSnackbar(val messageId: Int) : UiEvent()
}
