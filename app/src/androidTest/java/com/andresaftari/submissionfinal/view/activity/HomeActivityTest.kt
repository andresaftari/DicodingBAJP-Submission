package com.andresaftari.submissionfinal.view.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.andresaftari.submissionfinal.R
import com.andresaftari.submissionfinal.data.local.dummy.DummyModel
import com.andresaftari.submissionfinal.utils.IdleResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DummyModel.setMovieData()
    private val dummyShow = DummyModel.setShowData()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(IdleResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(IdleResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        Espresso.onView(withId(R.id.rv_movies)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size)
        )
    }

    @Test
    fun loadShows() {
        Espresso.onView(withId(R.id.rv_movies)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withText(R.string.tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_shows)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.rv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShow.size)
        )
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_title)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_title)).check(
            ViewAssertions.matches(withText(dummyMovie[0].title))
        )
        Espresso.onView(withId(R.id.tv_detail_genre)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_genre)).check(
            ViewAssertions.matches(withText(dummyMovie[0].genre))
        )
        Espresso.onView(withId(R.id.tv_detail_description)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_description)).check(
            ViewAssertions.matches(withText(dummyMovie[0].description))
        )
    }

    @Test
    fun loadDetailShow() {
        Espresso.onView(withId(R.id.rv_movies)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withText(R.string.tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_title)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_title)).check(
            ViewAssertions.matches(withText(dummyShow[0].title))
        )
        Espresso.onView(withId(R.id.tv_detail_genre)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_genre)).check(
            ViewAssertions.matches(withText(dummyShow[0].genre))
        )
        Espresso.onView(withId(R.id.tv_detail_description)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_description)).check(
            ViewAssertions.matches(withText(dummyShow[0].description))
        )
    }

    @Test
    fun loadFavoritedMovies() {
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withText(R.string.favorite_m)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_favorite_movie)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_title)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_genre)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_description)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavoritedShows() {
        Espresso.onView(withId(R.id.rv_movies)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withText(R.string.tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(withText(R.string.favorite_s)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_favorite_show)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.rv_favorite_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_title)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_genre)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.tv_detail_description)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        Espresso.onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }
}