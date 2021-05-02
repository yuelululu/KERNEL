
package com.unhappychoice.norimaki.presentation.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.unhappychoice.circleci.CircleCIAPIClientV1
import com.gojuno.koptional.None
import com.gojuno.koptional.Some
import com.jakewharton.rxbinding2.view.clicks
import com.unhappychoice.norimaki.MainActivity
import com.unhappychoice.norimaki.R
import com.unhappychoice.norimaki.databinding.NavigationViewBinding
import com.unhappychoice.norimaki.domain.service.EventBusService
import com.unhappychoice.norimaki.extension.subscribeNext
import com.unhappychoice.norimaki.extension.subscribeOnIoObserveOnUI
import com.unhappychoice.norimaki.presentation.adapter.ProjectAdapter
import io.reactivex.disposables.CompositeDisposable