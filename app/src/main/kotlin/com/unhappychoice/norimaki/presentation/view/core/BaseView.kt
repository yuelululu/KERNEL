package com.unhappychoice.norimaki.presentation.view.core

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.unhappychoice.norimaki.presentation.presenter.core.Presenter
import io.reactivex.disposables.CompositeDisposable
import org.kodein.di.DI
import org.kodein.di.DIAware

abstract class BaseView<Self: BaseView<Self>>(
    context: Context?,
    attr: AttributeSet?
) : Linear