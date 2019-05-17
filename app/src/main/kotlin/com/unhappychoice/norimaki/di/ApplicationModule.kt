package com.unhappychoice.norimaki.di

import com.github.unhappychoice.circleci.CircleCIAPIClient
import com.github.unhappychoice.circleci.CircleCIAPIClientV1
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.unhappychoice.norimaki.NorimakiApplication
import com.unhappychoice.norimaki.domain.service.EventBusService
import com.unhappychoice.norimaki.infrastructure.preference.APITokenPreference
import com.unhappychoice.norimaki.infrastructure.pusher.PusherService
import org.kodein.di.*

fun applicationModule(application: NorimakiApplication) = DI.Module("application") {
    bind<NorimakiApplication>() with provider { application }
    bind<EventBusService>() with singleton { EventBusService() }
    bind<PusherService>() with singlet