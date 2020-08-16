package com.unhappychoice.norimaki.presentation.presenter.core

import com.unhappychoice.norimaki.extension.Variable
import io.reactivex.Observable

interface Loadable {
    val isLoading: Variable<Boolean>

    fun <T> i