package com.rightmove.codechallenge

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.rightmove.codechallenge.ui.main.MainActivity
import com.rightmove.codechallenge.ui.main.MainViewModel
import com.rightmove.codechallenge.ui.main.MainViewModelFactory
import io.mockk.coEvery
import io.mockk.mockk
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    companion object {
        private val viewModelMock = mockk<MainViewModel>()
        private val mainViewModelFactoryMock = mockk<MainViewModelFactory>()
    }

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private fun setUpViewModelMock() {
        coEvery {
            mainViewModelFactoryMock.create(MainViewModel::class.java)
        } coAnswers {
            viewModelMock
        }
    }

    @Test
    fun onStart() {
        onView(withId(R.id.main_average_title)).check(matches(isDisplayed()))
        onView(withId(R.id.main_average_title)).check(matches(withText(R.string.average_title)))

        onView(withId(R.id.main_average_loading_view)).check(matches(isDisplayed()))

        setUpViewModelMock()

        onView(withId(R.id.main_average_loading_view)).check(matches(not(isDisplayed())))

        onView(withId(R.id.main_average_value)).check(matches(isDisplayed()))
        onView(withId(R.id.main_average_value)).check(matches(withText("410,280.78")))
    }
}