package com.auldy.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.auldy.moviecatalogue.R
import com.auldy.moviecatalogue.utils.DataDummy
import com.auldy.moviecatalogue.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val movies = DataDummy.generateDummyMovies()
    private val tvshow = DataDummy.generateDummyTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                movies.size
            )
        )
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.background)).check(matches(isDisplayed()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(withText(movies[0].title)))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(withText(movies[0].releasedate)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(movies[0].genre)))
        onView(withId(R.id.durasi)).check(matches(isDisplayed()))
        onView(withId(R.id.durasi)).check(matches(withText(movies[0].durasi)))
        onView(withId(R.id.average)).check(matches(isDisplayed()))
        onView(withId(R.id.average)).check(matches(withText(movies[0].average)))
        onView(withId(R.id.tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tagline)).check(matches(withText(movies[0].tagline)))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(withText(movies[0].overview)))
        onView(withId(R.id.status)).check(matches(isDisplayed()))
        onView(withId(R.id.status)).check(matches(withText("Status : ${movies[0].status}")))
        onView(withId(R.id.language)).check(matches(isDisplayed()))
        onView(withId(R.id.language)).check(matches(withText("Language : ${movies[0].language}")))
        onView(withId(R.id.budget)).check(matches(isDisplayed()))
        onView(withId(R.id.budget)).check(matches(withText("Budget : ${movies[0].budget}")))
        onView(withId(R.id.revenue)).check(matches(isDisplayed()))
        onView(withId(R.id.revenue)).check(matches(withText("Revenue : ${movies[0].revenue}")))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                tvshow.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.background)).check(matches(isDisplayed()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches(withText(tvshow[0].title)))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(withText(tvshow[0].releasedate)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(tvshow[0].genre)))
        onView(withId(R.id.durasi)).check(matches(isDisplayed()))
        onView(withId(R.id.durasi)).check(matches(withText(tvshow[0].durasi)))
        onView(withId(R.id.average)).check(matches(isDisplayed()))
        onView(withId(R.id.average)).check(matches(withText(tvshow[0].average)))
        onView(withId(R.id.tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tagline)).check(matches(withText(tvshow[0].tagline)))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(withText(tvshow[0].overview)))
        onView(withId(R.id.status)).check(matches(isDisplayed()))
        onView(withId(R.id.status)).check(matches(withText("Status : ${tvshow[0].status}")))
        onView(withId(R.id.language)).check(matches(isDisplayed()))
        onView(withId(R.id.language)).check(matches(withText("Language : ${tvshow[0].language}")))
        onView(withId(R.id.budget)).check(matches(isDisplayed()))
        onView(withId(R.id.budget)).check(matches(withText("Budget : ${tvshow[0].budget}")))
        onView(withId(R.id.revenue)).check(matches(isDisplayed()))
        onView(withId(R.id.revenue)).check(matches(withText("Revenue : ${tvshow[0].revenue}")))

    }

    @Test
    fun loadFavoriteMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                movies.size
            )
        )
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())
        onView(withId(R.id.rv_fragmentmovies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fragmentmovies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                movies.size
            )
        )
        onView(withId(R.id.rv_fragmentmovies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())

    }

    @Test
    fun loadFavoriteTvShow() {
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                tvshow.size
            )
        )
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_fragmenttvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fragmenttvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                tvshow.size
            )
        )
        onView(withId(R.id.rv_fragmenttvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.btn_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())
        onView(withText(R.string.tvshow)).perform(click())
    }
}