package com.example.demo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.demo.utilClass.NavigationStack
import com.example.demo.ViewModelClass.HomeViewModel
import com.example.demo.ui.theme.DemoTheme

/**
 * Main activity file to render user login screen
 * Date: 14-01-2025
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
        setContent {
            DemoTheme {
                NavigationStack(homeViewModel)
         }
        }
    }
}


