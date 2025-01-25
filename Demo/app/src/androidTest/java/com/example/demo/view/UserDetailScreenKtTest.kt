package com.example.demo.view

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo.activity.MainActivity
import com.example.demo.utilClass.Screen
import com.example.demo.viewModelClass.HomeViewModel

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