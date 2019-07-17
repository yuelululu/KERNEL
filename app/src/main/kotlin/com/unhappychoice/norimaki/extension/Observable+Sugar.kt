package com.unhappychoice.norimaki.extension

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject

fun <T: Any> Observable<T>.subscribeNext(fn: (T) -> Unit): Disposable =
    subscribeBy(
        onNext = { fn(it) },
        onError = { it.printStackTrace() },
        onComplete = {}
    )

fun <T : Any> Observable<T>.subscribeError(fn: (e: Throwable?) -> Unit): Disposable =
    subscribeBy(
        onNext = {},
        onError = { fn(it) },
        onComplet