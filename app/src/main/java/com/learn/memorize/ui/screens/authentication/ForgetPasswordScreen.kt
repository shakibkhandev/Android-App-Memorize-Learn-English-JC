package com.learn.memorize.ui.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.learn.memorize.R

@Composable
fun ForgetPasswordScreen(navController: NavController, modifier: Modifier=Modifier, windowSize: WindowWidthSizeClass){
    var emailInput by remember { mutableStateOf("") }

    when(windowSize){
        WindowWidthSizeClass.Compact -> Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .imePadding()
                    .padding(16.dp), // Added padding for better spacing
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Sign-In Image
                Image(
                    painter = painterResource(R.drawable.forgot_password),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Email Input Field
                CustomTextField(
                    textInput = emailInput,
                    onChangeText = { newText -> emailInput = newText },
                    placeholder = "Enter Your Email",
                    leftIcon = Icons.Default.Email,
                    rightIcon = Icons.Default.Clear,
                    rightIconClicked = { emailInput = "" },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Sign-In Button
                ElevatedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Send OTP",
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }



            }
        }
        WindowWidthSizeClass.Expanded -> Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight()
            ){

            Image(
                painter = painterResource(R.drawable.forgot_password),
                contentDescription = null,
                modifier = modifier.fillMaxWidth()
            )
            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight().padding(10.dp).verticalScroll(
                    rememberScrollState()
                ),
                verticalArrangement = Arrangement.Center
            ) {



            // Email Input Field
            CustomTextField(
                textInput = emailInput,
                onChangeText = { newText -> emailInput = newText },
                placeholder = "Enter Your Email",
                leftIcon = Icons.Default.Email,
                rightIcon = Icons.Default.Clear,
                rightIconClicked = { emailInput = "" },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Sign-In Button
            ElevatedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Send OTP",
                        modifier = Modifier.padding(5.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            }


        }
    }
    }

}