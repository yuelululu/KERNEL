
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
        BuildAction(
            bashCommand = null,
            canceled = null,
            endTime = endTime,
            exitCode = null,
            failed = null,
            hasOutput = hasOutput,
            infrastructureFail = null,
            index = index,
            name = name,
            outputUrl = outputUrl,
            parallel = parallel,
            runTimeMillis = runTimeMillis,
            startTime = startTime,
            status = status,
            step = step,
            timedout = null,
            truncated = null,
            type = type
        )
}