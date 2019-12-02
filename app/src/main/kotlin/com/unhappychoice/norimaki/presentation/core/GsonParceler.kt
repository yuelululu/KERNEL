package com.unhappychoice.norimaki.presentation.core

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.unhappychoice.norimaki.presentation.screen.core.Screen
import flow.KeyParceler
import java.io.StringReader
import java.io.StringWriter

/**
 * From https://github.com/pyricau/dagger2-mortar-flow-experiment/blob/master/app/src/main/java/dagger/demo/mortarflow/GsonParceler.java
 */
class GsonParceler : KeyParceler {
    o