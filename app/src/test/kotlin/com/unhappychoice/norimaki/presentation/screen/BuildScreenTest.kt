package com.unhappychoice.norimaki.presentation.screen

import com.github.unhappychoice.circleci.response.Build
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.unhappychoice.norimaki.R
import com.unhappychoice.norimaki.domain.model.revisionString
import com.winterbe.expekt.expect
import io.polymorphicpanda.kspec.KSpec
import io.polymorphicpanda.kspec.describe
import io.polymorphicpanda.kspec.it
import io.polymorphicpanda.kspec.junit.JUnitKSpecRunner
import org.junit.runner.RunWith

@RunWith(JUnitKSpecRunner::class)
class BuildScreenTest : KSpec() {
    lateinit var subject: BuildScreen
    lateinit var build: Build

    override fun spec() {
        beforeEach {
            build =