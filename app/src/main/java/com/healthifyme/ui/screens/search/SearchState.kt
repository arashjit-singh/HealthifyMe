package com.healthifyme.ui.screens.search

import com.healthifyme.domain.TrackableFood

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
        val trackableFood: List<TrackableFood> = emptyList()
)