package com.unhappychoice.norimaki.extension

import org.json.JSONArray
import org.json.JSONObject

fun JSONArray.asSequence(): Sequence<JSONObject> = iterator().a