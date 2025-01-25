package com.example.demo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.demo.R
import com.example.demo.utilClass.Screen
import com.example.demo.ViewModelClass.HomeViewModel

/**
 * User Details Screen Composable function
 * Date: 14-01-2025
 */

@Composable
fun UserDetailScreen(text: String?, viewModel: HomeViewModel, navController: NavHostController) {
    val mContext = LocalContext.current
    val isLoading =viewModel.isLoading.observeAsState()
    val userDetails = viewModel.userLiveData.observeAsState()
    val userPostsIS = viewModel.userPostLiveData.observeAsState()


    Surface(modifier = Modifier.fillMaxSize().testTag("UserDetailTestTag")) {

        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(.2f),
                contentAlignment = Alignment.CenterStart

            ) {
                Row(modifier = Modifier.padding(horizontal = 10.dp).testTag("DetailScrTag")) {
                    Text(
                        text = "Welcome: ",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp
                    )

                    Text(
                        text = "$text",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 25.sp
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp, 0.dp, 0.dp, 10.dp), verticalArrangement = Arrangement.Top,

                    horizontalAlignment = Alignment.Start) {

                    Button(onClick = {

                        navController.navigate(route = Screen.PlantScreen.route )
                    },colors = ButtonDefaults.buttonColors(Color(0XFF0F9D58)))
                    {
                        Text(text = ContextCompat.getString(
                            mContext,
                            R.string.plant_scr_title
                        ))
                    }
// Adding a Spacer of height 200dp
                    Spacer(modifier = Modifier.height(20.dp))

                    Button(onClick = { viewModel.getUserData() },colors = ButtonDefaults.buttonColors(Color(0XFF0F9D58)))
                    {
                        Text(text =ContextCompat.getString(
                            mContext,
                            R.string.user_profile_label
                        ))
                    }
                    Box() {
                        Column(modifier = Modifier.fillMaxSize().padding(20.dp,5.dp,10.dp,10.dp), verticalArrangement = Arrangement.Top,

                            horizontalAlignment = Alignment.Start)
                        {

                            if (isLoading.value == true) {
                                CircularProgressIndicator()
                            } else {

                                userDetails.value?.id?.let {
                                    CustomRow("Id", "$it")
                                }
                                userDetails.value?.name?.let {
                                    CustomRow("Name", "$it")
                                }
                                userDetails.value?.email?.let {
                                    CustomRow("Email Id", "$it")
                                }
                                userDetails.value?.company?.let {
                                    CustomRow("Company", "$it")
                                }
                                userDetails.value?.location?.let {
                                    CustomRow("Location", "$it")
                                }
                                userDetails.value?.publicRepos?.let {
                                    CustomRow("Public Repository", "$it")
                                }
                                userDetails.value?.followers?.let {
                                    CustomRow("Followers", "$it")
                                }
                                userDetails.value?.following?.let {
                                    CustomRow("Following", "$it")
                                }
                                userDetails.value?.blog?.let {
                                    CustomRow("Following", "$it")
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CustomRow(title:String,value:String) {
    val textStyle = TextStyle(fontSize = 20.sp, color = Color.Black)

    Card(
        modifier = Modifier
            // The space between each card and the other
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = androidx.compose.material.MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = androidx.compose.material.MaterialTheme.colors.surface,

        ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "$title :$value", style = textStyle)
        }
    }


}

