package com.unhappychoice.norimaki.extension

import java.util.*

fun Date.getTimeAgo(): String {
    val before = time / 1000
    val now = Calendar.getInstance().timeInM