package com.unhappychoice.norimaki.presentation.screen

import com.github.unhappychoice.circleci.response.Build
import com.github.unhappychoice.circleci.response.BuildStep
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.unhappychoice.norimaki.R
import com.winterbe.expekt.expect
import io.polymorphicpanda.kspec.KSpec
import io.polymorphicpanda.kspec.describe
import io.polymorphicpanda.kspec.it
import io.polymorphicpanda.kspec.junit.JUnitKSpecRunner
import org.junit.runner.RunWith

@RunWith(JUnitKSpecRunner::class)
class BuildStepScreenTest : KSpec() {
    lateinit var subject: BuildStepScreen
    lateinit var build: Build
    lateinit var buildStep: BuildStep
    val stepIndex = 0

    override fun spec() {
        beforeEach {
            build = mock { }
            buildStep = mock { on { name } doReturn("build name") }
            subject = BuildStep