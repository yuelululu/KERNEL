package com.unhappychoice.norimaki

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.unhappychoice.norimaki.databinding.ActivityMainBinding
import com.unhappychoice.norimaki.databinding.NavigationViewBinding
import com.unhappychoice.norimaki.di.activityModule
import com.unhappychoice.norimaki.di.applicationModule
import com.unhappychoice.norimaki.presentation.core.GsonParceler
import com.unhappychoice.norimaki.presentation.core.ScreenChanger
import com.unhappychoice.norimaki.presentation.screen.BuildListScreen
import com.unhappychoice.norimaki.presentation.view.NavigationView
import com.unhappychoice.norimaki.presentation.view.core.HasMenu
import flow.Flow
import flow.KeyDispatcher
import mortar.MortarScope
import mortar.bundler.BundleServiceRunner
import org.kodein.di.DI

class MainActivity : AppCompatActivity() {
    val module by lazy {
        DI {
            import(applicationModule(application as NorimakiApplication))
            import(activityModule(this@MainActivity))
        }
    }

    val drawerToggle by lazy {
        ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.drawer_open, R.string.drawer_close)
            .apply { setToolbarNavigationClickListen