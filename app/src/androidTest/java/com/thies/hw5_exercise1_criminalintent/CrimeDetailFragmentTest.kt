package com.thies.hw5_exercise1_criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.FragmentScenario.Companion.launch
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        // used the following link for help in using launchFragmentInContainer function
        // https://forums.bignerdranch.com/t/testing-fragment-scenario-ch-9/20832/5
        scenario = launchFragmentInContainer()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun checkBoxConnectedToFragment() {
        onView(withId(R.id.crime_solved)).perform(click())

        // used the following link to better understand the onFragment function
        // https://medium.com/google-developer-experts/exploring-the-android-fragment-scenario-component-e369ec587419#:~:text=scenario.onFragment%20%7B%20it.onUserSignedOut%20%28%29%20%7D%20This%20onFragment%20function,functions%20that%20can%20be%20triggered%20on%20our%20fragments.
        scenario.onFragment {
            it.crime.isSolved
        }
    }

    @Test
    fun editTextConnectedToFragment() {
        // used link to learn how to type text into element
        // https://developer.android.com/training/testing/espresso/basics
        onView(withId(R.id.crime_title)).perform(typeText("Hello"))

        scenario.onFragment {
            it.crime.title
        }
    }
}