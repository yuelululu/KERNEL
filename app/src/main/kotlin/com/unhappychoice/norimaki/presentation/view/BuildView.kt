
package com.unhappychoice.norimaki.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unhappychoice.norimaki.databinding.BuildViewBinding
import com.unhappychoice.norimaki.extension.subscribeNext
import com.unhappychoice.norimaki.extension.subscribeOnIoObserveOnUI
import com.unhappychoice.norimaki.presentation.adapter.BuildStepAdapter
import com.unhappychoice.norimaki.presentation.presenter.BuildPresenter
import com.unhappychoice.norimaki.presentation.view.core.BaseView
import com.unhappychoice.norimaki.presentation.view.core.HasMenu
import io.reactivex.rxkotlin.addTo
import org.kodein.di.instance

class BuildView(context: Context, attr: AttributeSet) : BaseView<BuildView>(context, attr), HasMenu {
    override val presenter: BuildPresenter by instance()

    private val binding by lazy {
        BuildViewBinding.bind(this)
    }

    private val adapter = BuildStepAdapter(context)

    override fun onCreateOptionsMenu(menu: Menu?) {
        menu?.add(Menu.NONE, MenuResource.Rebuild.id, Menu.NONE, "Rebuild")
        menu?.add(Menu.NONE, MenuResource.RebuildWithoutCache.id, Menu.NONE, "Rebuild without cache")
    }

    override fun onOptionsItemSelected(item: MenuItem?) {