package com.example.demo.view

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.takeScreenshot
import com.example.demo.ViewModelClass.HomeViewModel
import com.example.demo.activity.MainActivity
import com.example.demo.utilClass.Screen
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test for user detail screen
 * Date: 24-01-2025
 */
class UserDetailScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private var viewModel = HomeViewModel()
    private val mDelayTime = 2000

    @Before
    fun setUp() {
        println("Before test case execution")
        // Render the Compose UI
        composeTestRule.activity.setContent {
            var navController = rememberNavController()
            // Call the entry point composable function
            NavHost(navController = navController, startDestination = Screen.DetailsScreen.route) {

                composable(Screen.DetailsScreen.route) {
                    UserDetailScreen(
                        "Hello",
                        viewModel,
                        navController
                    )
                } // Your composable screen
                composable(Screen.PlantScreen.route) { AllPlantsScreen() }
            }

        }
    }

    @After
    fun tearDown() {
        println("After test case execution")
    }

    @Test
    fun varifyUserScreen_Navigation() {

        composeTestRule.onNodeWithText("Welcome: ").assertIsDisplayed()
        composeTestRule.onNodeWithText("Get Plant Details").assertIsDisplayed()
        composeTestRule.onNodeWithText("Get User Profile Data").assertIsDisplayed()

        composeTestRule.onNodeWithText("Get Plant Details").performClick()

        composeTestRule.onNodeWithText("\uD83C\uDF3F  Plant List").assertIsDisplayed()
        composeTestRule.onNodeWithTag("MyTesting").isDisplayed()
        composeTestRule.onNodeWithText("Lavender").performScrollTo()
        composeTestRule.onNodeWithText("Lavender").performClick()
        composeTestRule.onNodeWithText("Lavender").captureToImage()

        Thread.sleep(mDelayTime.toLong())
        takeScreenshot()
    }


}