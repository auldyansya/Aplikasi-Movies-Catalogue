package com.auldy.moviecatalogue.utils

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
object EspressoIdlingResources {
    private const val RESOURCE = "GLOBAL"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}