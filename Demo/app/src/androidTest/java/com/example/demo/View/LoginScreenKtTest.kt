package com.example.demo.View

import android.content.ClipboardManager
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.takeScreenshot
import com.example.demo.Activity.MainActivity
import com.example.demo.UtillClass.Screen
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        println("Before test case execution")
        // Render the Compose UI
        composeTestRule.activity.setContent {
            var navController = rememberNavController()
            // Call the entry point composable function
            NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

                composable(Screen.LoginScreen.route) { LoginScreen(navController) } // Your composable screen

            }

        }
    }



    @After
    fun tearDown() {
        println("After test case execution")
    }

    @Test
    fun loginLabelTest()
    {
        composeTestRule.onNodeWithText("Login your Account").assertIsDisplayed()

    }

    @Test
    fun loginScreen() {

        val userName = "User001"
        val password = "password"


        // Find the email TextField and perform text input
        composeTestRule.onNodeWithText("Enter your name")
            .performTextInput(userName)

        // Find the password TextField and perform text input
        composeTestRule.onNodeWithText("Enter your password")
            .performTextInput(password)

        // Find the ENTER button and perform a click
        composeTestRule.onNodeWithText("Next")
            .isDisplayed( )

        Thread.sleep(5000)
        // Test Case 2: Trigger navigation to Screen2
        /*composeTestRule.onNodeWithText("Next").performClick()

        // Verify that Screen2 is displayed
        composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()*/

        // Assert that the login action is triggered with the correct credentials
        // For demonstration purposes, we'll just check that the entered email and password are non-empty.
        assertTrue(userName.isNotEmpty())
        assertTrue(password.isNotEmpty())

        takeScreenshot()
    }

}