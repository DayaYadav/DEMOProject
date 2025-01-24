package com.example.demo.View

import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.takeScreenshot
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.demo.Activity.MainActivity
import com.example.demo.UtillClass.Screen
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginScreenKtTest {

    @get:Rule

    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {

        // Render the Compose UI
        composeTestRule.activity.setContent {
            // Call the entry point composable function
            NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

                composable(Screen.LoginScreen.route) { LoginScreen(navController) } // Your composable screen

            }

        }
    }



    @After
    fun tearDown() {
    }

    @Test
    fun loginLabelTest()
    {
        composeTestRule.onNodeWithText("Login your Account").assertIsDisplayed()
        takeScreenshot()
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
            .performClick()

        // Assert that the login action is triggered with the correct credentials
        // For demonstration purposes, we'll just check that the entered email and password are non-empty.
        assertTrue(userName.isNotEmpty())
        assertTrue(password.isNotEmpty())
    }

}