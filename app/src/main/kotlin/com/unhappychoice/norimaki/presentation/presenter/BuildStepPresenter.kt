package com.unhappychoice.norimaki.presentation.presenter

import com.github.unhappychoice.circleci.response.Build
import com.github.unhappychoice.circleci.response.BuildAction
import com.github.unhappychoice.circleci.response.BuildStep
import com.unhappychoice.norimaki.domain.model.step
import com.unhappychoice.norimaki.extension.*
import com.unhappychoice.norimaki.presentation.presenter.core.PresenterNeedsToken
import com.unhappychoice.norimaki.presentation.view.BuildStepView
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import mortar.MortarScope
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.kodein.di.instance

class BuildStepPresenter: PresenterNeedsToke