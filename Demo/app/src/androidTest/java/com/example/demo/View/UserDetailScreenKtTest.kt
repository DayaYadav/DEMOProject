package com.example.demo.View

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.takeScreenshot
import com.example.demo.Activity.MainActivity
import com.example.demo.UtillClass.Screen
import com.example.demo.ViewModelClass.HomeViewModel
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserDetailScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private var viewModel = HomeViewModel()

    @Before
    fun setUp() {
        println("Before test case execution")
        // Render the Compose UI
        composeTestRule.activity.setContent {
            var navController = rememberNavController()
            // Call the entry point composable function
            NavHost(navController = navController, startDestination = Screen.DetailsScreen.route) {

                composable(Screen.DetailsScreen.route) { UserDetailScreen("Hello",viewModel,navController) } // Your composable screen

            }

        }
    }

    @After
    fun tearDown() {
        println("After test case execution")
    }

    @Test
    fun varifyLabelTest() {

        composeTestRule.onNodeWithText("Welcome: ").assertIsDisplayed()
        composeTestRule.onNodeWithText("Get Plant Details").assertIsDisplayed()
        composeTestRule.onNodeWithText("Get User Profile Data").assertIsDisplayed()
        Thread.sleep(5000)
        composeTestRule.onNodeWithText("Get User Profile Data").captureToImage()
        //composeTestRule.onNodeWithText("Get Plant Details").performClick()

     }



}