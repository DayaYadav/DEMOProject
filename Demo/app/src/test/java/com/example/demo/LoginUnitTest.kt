package com.example.demo

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.demo.activity.MainActivity
import com.example.demo.utilClass.CommonUtillClass
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginUnitTest {
    @JvmField
    @Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)
    @get:Rule
    val composeTestRule = createComposeRule()
    @Before
    fun setUp() {
        println("Before test start execution")
    }

    @After
    fun tearDown() {
        println("After test execution")
    }

    @Test
    fun ValidateInputStringTest() {
        var result = CommonUtillClass.ValidateInputString("Hello", 10)

        assertEquals(true, result)

    }


    @Test
    fun ValidateInputStringTestfalse() {
        var result = CommonUtillClass.ValidateInputString("Hello ,Good Morning", 10)

        assertEquals(
            false, result
        )

    }


    @Test
    fun ValidateBlankInputString() {
        var result = CommonUtillClass.ValidateInputString("", 10)

        assertEquals(
            false, result
        )

    }

}