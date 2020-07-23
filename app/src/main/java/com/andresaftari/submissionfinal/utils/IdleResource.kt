package com.andresaftari.submissionfinal.utils

import androidx.test.espresso.idling.CountingIdlingResource

object IdleResource {
    private const val RESOURCE = "GLOBAL"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}