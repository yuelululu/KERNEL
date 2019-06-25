package com.unhappychoice.norimaki.extension

import java.util.*

fun Date.getTimeAgo(): String {
    val before = time / 1000
    val now = Calendar.getInstance().timeInMillis / 1000
    val offset = Calendar.getInstance().timeZone.rawOffset / 1000
    val difference = now - before - offset

    return when {
        difference < 0 -