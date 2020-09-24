package com.unhappychoice.norimaki.presentation.presenter.core

import android.os.Handler
import android.view.View
import com.github.unhappychoice.circleci.CircleCIAPIClientV1
import com.github.unhappychoice.circleci.response.User
import com.unhappychoice.norimaki.MainActivity
import com.unhappychoice.norimaki.domain.service.EventBusService
import com.unhappychoice.norimaki.extension.goTo
import com.unhappychoice.norimaki.extension.subscribeNext
import com.unhappychoice.norimaki.extension.subscribeOnIoObserveOnUI
import com.unhappychoice.norimaki.extension.withLog
import com.unhappychoice.nor