
package com.unhappychoice.norimaki.di

import com.unhappychoice.norimaki.MainActivity
import com.unhappychoice.norimaki.presentation.presenter.APITokenPresenter
import com.unhappychoice.norimaki.presentation.presenter.BuildListPresenter
import com.unhappychoice.norimaki.presentation.presenter.BuildPresenter
import com.unhappychoice.norimaki.presentation.presenter.BuildStepPresenter
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.provider
import org.kodein.di.singleton

fun activityModule(activity: MainActivity) = DI.Module("activity") {
    bind<MainActivity>() with provider { activity }
    bind<APITokenPresenter>() with singleton { APITokenPresenter() }
    bind<BuildListPresenter>() with provider { BuildListPresenter() }
    bind<BuildPresenter>() with provider { BuildPresenter() }
    bind<BuildStepPresenter>() with provider { BuildStepPresenter() }
}