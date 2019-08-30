
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