package com.example.demo.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.demo.R
import com.example.demo.utilClass.CommonUtilClass
import com.example.demo.utilClass.Screen

/**
 * Login Screen Composable function
 * Date: 14-01-2025
 */
@Composable
fun LoginScreen(navController: NavController) {
    val mContext = LocalContext.current
    val mPassword = remember { mutableStateOf("") }
    val mUsername = remember { mutableStateOf("") }
    val mMaxUserNameLen = 10
    val mMaxPasswordLen= 20
    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(.5f),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                    Text(
                        text = ContextCompat.getString(
                            mContext,
                            R.string.login_label
                        ),
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
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
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedTextField(
                        value = mUsername.value,
                        maxLines = 12,

                        onValueChange = {
                            if(!CommonUtilClass.ValidateInputString(it,mMaxUserNameLen))
                            {
                                Toast.makeText(mContext,"You can not enter more then $mMaxUserNameLen characters",Toast.LENGTH_SHORT).show()
                            }else{
                                mUsername.value = it
                            }
                        },
                        label = {
                            Text(
                                text = ContextCompat.getString(
                                    mContext,
                                    R.string.name_text
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = mPassword.value,
                        onValueChange = {
                            if (!CommonUtilClass.ValidateInputString(it, mMaxPasswordLen)) {
                                Toast.makeText(
                                    mContext,
                                    "You can not enter more then $mMaxPasswordLen characters",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                mPassword.value = it
                            }
                        },
                        label = {
                            Text(
                                text = ContextCompat.getString(
                                    mContext,
                                    R.string.password_text
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            ) {

                Button(
                    onClick = {
                        if (mUsername.value.isNotEmpty() and mPassword.value.isNotEmpty()) {
                            navController.navigate(route = Screen.DetailsScreen.route + "?text=${mUsername.value}")
                        }else{
                            if (!CommonUtilClass.ValidateInputString(mUsername.value,0) || CommonUtilClass.ValidateInputString(mPassword.value,0)) {

                                Toast.makeText(mContext, ContextCompat.getString(
                                    mContext,
                                    R.string.user_pass_empty_msg
                                )
                                    , Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0XFF0F9D58)),
                ) {
                    Text("Next", color = Color.White)
                }

            }

        }
    }
}

