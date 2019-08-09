package com.unhappychoice.norimaki.extension

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlin.reflect.KProperty

class Variable<T>(value: T) {
    private var _value: T = 