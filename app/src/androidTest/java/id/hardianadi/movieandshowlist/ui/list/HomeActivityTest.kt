package id.hardianadi.movieandshowlist.ui.list

import android.os.SystemClock
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import id.hardianadi.movieandshowlist.R
import id.hardianadi.movieandshowlist.ui.detail.MovieDetailActivity
import id.hardianadi.movieandshowlist.ui.movie.MovieAdapter
import id.hardianadi.movieandshowlist.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @since 11/09/2020
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {
    @get:Rule
    var mActivityRule = ActivityScenarioRule(HomeActivity::class.java)

    @get:Rule
    var mDetailActivityRule = ActivityScenarioRule(MovieDetailActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }


    @Test
    fun assertCheckMovieList() {
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.viewPager)).perform(swipeRight())
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MovieViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText("Money Plane")))
        onView(withId(R.id.rvCast)).check(matches(isDisplayed()))
        onView(withId(R.id.rvCast)).check(RecyclerViewItemCountAssertion(14))
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click())
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
    }

    @Test
    fun assertCheckShowList() {
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rvShow)).check(matches(isDisplayed()))
        SystemClock.sleep(1000)
        onView(withId(R.id.rvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.MovieViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText("The Boys")))
        onView(withId(R.id.rvCast)).check(matches(isDisplayed()))
        onView(withId(R.id.rvCast)).check(RecyclerViewItemCountAssertion(13))
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click())
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
    }

    class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            if (noViewFoundException != null) {
                throw noViewFoundException
            }

            val recyclerView = view as RecyclerView
            val adapter = recyclerView.adapter
            assert(adapter?.itemCount == expectedCount)
        }

    }

}