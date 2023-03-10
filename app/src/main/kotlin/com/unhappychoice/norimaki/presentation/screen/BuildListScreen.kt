
package com.unhappychoice.norimaki.presentation.screen

import com.unhappychoice.norimaki.R
import com.unhappychoice.norimaki.presentation.screen.core.Screen
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

class BuildListScreen(val projectName: String) : Screen() {
    override fun getTitle(): String = if (projectName == "") "Recent Builds" else projectName
    override fun getLayoutResource() = R.layout.build_list_view

    override fun module(activityModule: DI) = DI {
        extend(activityModule)
        bind<String>() with singleton  { projectName }
    }

    override fun equals(other: Any?): Boolean {
        val os = other as? BuildListScreen
        if (os == null || os.projectName != projectName) {
            return false
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return projectName.hashCode()
    }
}