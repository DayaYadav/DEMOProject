package com.example.demo.View

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
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

  private lateinit var navController: TestNavHostController

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        // Mock our View Model to stub out calls later
      //  viewModel = mock()
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
    }

    @Test
    fun userDetailScreen() {

        composeTestRule.onNodeWithText("Welcome: ").assertIsDisplayed()
        takeScreenshot()

    }

    @Test
    fun customRow() {
    }
}