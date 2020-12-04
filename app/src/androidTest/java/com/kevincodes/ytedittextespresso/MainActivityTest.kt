package com.kevincodes.ytedittextespresso

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    private lateinit var stringToBeTyped: String

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Before
    fun setUp() {

        stringToBeTyped = "Hello Espresso!"

        launchActivity<MainActivity>()
    }

    @Test
    fun textView_should_change_after_button_click() {
        // Type text and then press button
        onView(withId(R.id.textInput)).perform(typeText(stringToBeTyped), closeSoftKeyboard())

        onView(withId(R.id.clickMeButton)).perform(click())

        // Check that the textView was changed
        onView(withId(R.id.textToBeChanged)).check(matches(withText(stringToBeTyped)))
    }
}