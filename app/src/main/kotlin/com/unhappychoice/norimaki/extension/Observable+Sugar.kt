package com.unhappychoice.norimaki.extension

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject

fun <T: Any> Observable<T>.subscribeNext(fn: (T) -> Unit