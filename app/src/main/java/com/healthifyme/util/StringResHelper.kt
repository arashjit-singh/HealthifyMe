package com.healthifyme.util

import android.content.Context

sealed class StringResHelper {
    fun asString(context: Context, resId: Int): String {
        return context.getString(resId)
    }
}