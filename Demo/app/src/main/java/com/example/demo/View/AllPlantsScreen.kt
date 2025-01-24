package com.example.demo.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.demo.UtillClass.plants

/**
 * Display list of plants in list with title/description/image
 * Date:20-01-2025
 */
@Composable
fun AllPlantsScreen() {
    var platList = plants

    Surface(modifier = Modifier.fillMaxSize()) {

            LazyColumn(
                Modifier.fillMaxWidth().testTag("MyTest"),
                contentPadding = PaddingValues(16.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(vertical = 25.dp)
                            ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                                           ) {
                        Text(
                            "\uD83C\uDF3F  Plant List",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                }
                items(platList) { plant ->
                    PlantCard(plant.name, plant.description, plant.imageRes)
                }
            }
        }
    }