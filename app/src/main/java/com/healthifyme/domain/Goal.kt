package com.healthifyme.domain

sealed class Goal(val value: String) {
    object Loose : Goal("Loose")
    object Keep : Goal("Keep")
    object Gain : Goal("Gain")

    companion object {
        fun fromString(value: String): Goal {
            return when (value) {
                "Loose" -> Goal.Loose
                "Keep" -> Goal.Keep
                "Gain" -> Goal.Gain
                else -> Goal.Loose
            }
        }
    }
}
