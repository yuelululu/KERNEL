package com.unhappychoice.norimaki.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.unhappychoice.circleci.response.Project
import com.jakewharton.rxbinding2.view.clicks
import com.unhappychoice.norimaki.R
import com.unhappychoice.norimaki.extension.Variable
import com.unhappychoice.norimaki.extension.subscribeNext
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject

class ProjectAdapter(val context: Context) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {
    val projects = Variable<List<Project>>(emptyList())
    val onClickItem = PublishSubject.create<Project>()
    private val bag = CompositeDisposable()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = projects.value[position].vcsUrl.hashCode().toLong()

    override fun getItemCount(): Int = projects.value.size

    override fun