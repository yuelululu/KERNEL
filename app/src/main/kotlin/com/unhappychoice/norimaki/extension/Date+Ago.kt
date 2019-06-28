package com.unhappychoice.norimaki.extension

import java.util.*

fun Date.getTimeAgo(): String {
    val before = time / 1000
    val now = Calendar.getInstance().timeInMillis / 1000
    val offset = Calendar.getInstance().timeZone.rawOffset / 1000
    val difference = now - before - offset

    return when {
        difference < 0 -> "now"
        difference < MINUTES -> difference.toString() + "s ago"
        difference < HOURS -> (difference / MINUTES).toString() + "m ago"
        difference < DAYS -> (difference / HOURS).toString() + "h ago"
        difference < WEEKS -> (difference / 