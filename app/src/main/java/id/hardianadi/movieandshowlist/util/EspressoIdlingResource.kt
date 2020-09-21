package id.hardianadi.movieandshowlist.util

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 16/09/2020
 */
object EspressoIdlingResource {
    private val RESOURCE: String? = "GLOBAL"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)
    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResource(): IdlingResource {
        return espressoTestIdlingResource
    }
}