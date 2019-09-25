package com.unhappychoice.norimaki.infrastructure.pusher.extension

import android.util.Log
import com.pusher.client.channel.Channel
import com.pusher.client.channel.PrivateChannelEventListener
import com.pusher.client.channel.PusherEvent
import io.reactivex.Observable

fun Channel.privateChannelEvents(eventName: String): Observable<String> {
    var listener: PrivateChannelEventListener? = null
    return Observable.create<String> { observer ->
        listener = object : PrivateChannelEventListener {
            override fun onAuthenticationFailure(message: String?, e: Exception?) {
                Log.e("Pushe