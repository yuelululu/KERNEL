
package com.unhappychoice.norimaki.infrastructure.pusher

import com.github.unhappychoice.circleci.response.Build
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import com.pusher.client.channel.Channel
import com.pusher.client.util.HttpAuthorizer
import com.unhappychoice.norimaki.domain.model.channelName
import com.unhappychoice.norimaki.domain.service.EventBusService
import com.unhappychoice.norimaki.extension.bindTo
import com.unhappychoice.norimaki.extension.subscribeNext
import com.unhappychoice.norimaki.extension.withLog
import com.unhappychoice.norimaki.infrastructure.pusher.extension.privateChannelEvents
import com.unhappychoice.norimaki.infrastructure.pusher.response.Action
import com.unhappychoice.norimaki.infrastructure.pusher.response.OutAction
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

class PusherService(eventBus: EventBusService, val gson: Gson) {
    val buildListUpdated: PublishSubject<Unit> = PublishSubject.create()

    private var pusher: Pusher? = null
    private var channels: MutableMap<String, Channel> = mutableMapOf()
    private val bag = CompositeDisposable()
    private val subscriptionBag = CompositeDisposable()

    init {
        eventBus.authenticated
            .withLog("authenticated")
            .subscribeNext { connect(it.first, it.second) }
            .addTo(bag)

        eventBus.unauthenticated
            .subscribeNext { close() }
            .addTo(bag)
    }

    fun newActionEvents(build: Build): Observable<Action> =
        subscribe(build.channelName(), "newAction")
            .map { gson.fromJson<List<Action>>(it, object : TypeToken<List<Action>>() {}.type) }
            .flatMap { Observable.fromIterable(it) }

    fun updateActionEvents(build: Build): Observable<Action> =
        subscribe(build.channelName(), "updateAction")
            .map { gson.fromJson<List<Action>>(it, object : TypeToken<List<Action>>() {}.type) }
            .flatMap { Observable.fromIterable(it) }

    fun appendActionEvents(build: Build): Observable<OutAction> =
        subscribe(build.channelName(), "appendAction")
            .map { gson.fromJson<List<OutAction>>(it, object : TypeToken<List<OutAction>>() {}.type) }
            .flatMap { Observable.fromIterable(it) }
