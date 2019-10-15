
package com.unhappychoice.norimaki.infrastructure.pusher.response

import com.github.unhappychoice.circleci.response.BuildAction
import java.util.*

data class ActionLog(
    val background: Boolean,
    val endTime: Date,
    val hasOutput: Boolean,
    val index: Int,
    val name: String,
    val outputUrl: String?,
    val parallel: Boolean,
    val runTimeMillis: Int?,
    val status: String,
    val startTime: Date,
    val step: Int,
    val type: String
) {
    fun toBuildAction(): BuildAction =