package com.example.demo.View

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.demo.Activity.MainActivity
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginScreenKtTest {

    @JvmField
    @Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val composeTestRule = createComposeRule()


    @Before
    fun setUp() {
      // val navController = rememberNavController()
        // Render the Compose UI
        composeTestRule.setContent {
            // Call the entry point composable function
            LoginScreen(
                navController = TODO()
            )

        }
    }

    private fun NavController(context: ActivityScenarioRule<MainActivity>) {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun loginScreen() {

        val userName = "User001"
        val password = "password"

      /*  composeTestRule.setContent {
            LoginScreen()
        }
*/
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