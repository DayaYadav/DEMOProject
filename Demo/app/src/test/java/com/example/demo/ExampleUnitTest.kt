package com.example.demo

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.demo.activity.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @JvmField
    @Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)
    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }



}