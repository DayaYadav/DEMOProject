package com.example.demo.View

import android.os.Build
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.core.app.takeScreenshot
import androidx.test.filters.SdkSuppress
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalTestApi
@SdkSuppress(minSdkVersion = Build.VERSION_CODES.O)
class AllPlantsScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun plantUIComponentTest() {
        // Render the Compose UI
        composeTestRule.setContent {
            // Call the entry point composable function
            AllPlantsScreen()
        }
    }

    @Test
    fun validatelabelScreenshot() {

        composeTestRule.onNodeWithText("\uD83C\uDF3F  Plant List").assertIsDisplayed()
        takeScreenshot()
    }

    @Test
    fun scrollListScreenshot() {

        composeTestRule.onNodeWithText("Lavender").performScrollTo()
        takeScreenshot()
    }


    @Test
    fun clickEventTest() {
        composeTestRule.onNodeWithText("Rose").performClick()
        takeScreenshot()
    }


}