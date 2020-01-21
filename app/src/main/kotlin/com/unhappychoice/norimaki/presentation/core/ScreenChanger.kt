
package com.unhappychoice.norimaki.presentation.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unhappychoice.norimaki.MainActivity
import com.unhappychoice.norimaki.presentation.screen.APITokenScreen
import com.unhappychoice.norimaki.presentation.screen.BuildListScreen
import com.unhappychoice.norimaki.presentation.screen.core.Screen
import com.unhappychoice.norimaki.presentation.view.core.BaseView
import flow.*

class ScreenChanger(val activity: MainActivity) : KeyChanger {
    private val containerView: ViewGroup
        get() = activity.binding.containerView

    private val contentView: View
        get() = containerView.getChildAt(0)

    override fun changeKey(
        outgoingState: State?,
        incomingState: State,
        direction: Direction,
        incomingContexts: MutableMap<Any, Context>,
        callback: TraversalCallback
    ) {
        outgoingState?.save(contentView)
        containerView.removeAllViews()

        val screen = incomingState.getScreen()

        screen?.inflateView()?.let {
            inject(screen, it)
            containerView.addView(it)
            incomingState.restore(it)
        }

        callback.onTraversalCompleted()

        screen?.let { updateActionBar(it) }
    }

    private fun updateActionBar(screen: Screen) {
        activity.drawerToggle.isDrawerIndicatorEnabled = screen is BuildListScreen
        activity.supportActionBar?.setHomeButtonEnabled(true)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(hasScreens())
        activity.supportActionBar?.setDisplayShowHomeEnabled(false)
        activity.supportActionBar?.title = screen.getTitle()
        activity.invalidateOptionsMenu()
