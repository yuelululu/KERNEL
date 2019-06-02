package com.unhappychoice.norimaki.domain.model

import android.graphics.Color
import com.github.unhappychoice.circleci.response.Build

fun Build.repositoryString(): String = "$username / $reponame"
fun Build.revisionString(): String = "$branch #$buildNum (${vcsRevision?.take(6)})"

fun Build.statusColor(): Int = when (status) {
    "success", "fixed", "no_tests" -> Color.rgb(66, 200, 138)
    "canceled" -> Color.rgb(137, 137, 137)
    "infrastructure_fai