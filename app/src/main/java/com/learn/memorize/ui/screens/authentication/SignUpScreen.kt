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
import androidx.compose.material.icons.filled.AccountCircle
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
fun SignUpScreen(navController: NavController, modifier: Modifier = Modifier, windowSize: WindowWidthSizeClass){
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var nameInput by remember { mutableStateOf("") }


    when(windowSize){
        WindowWidthSizeClass.Compact ->     Box(modifier = Modifier.fillMaxSize()) {
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
                    painter = painterResource(R.drawable.sign_up_pana),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth()
                )

                // Email Input Field
                CustomTextField(
                    textInput = nameInput,
                    onChangeText = { newText -> nameInput = newText },
                    placeholder = "Enter Your Name",
                    leftIcon = Icons.Default.AccountCircle,
                    rightIcon = Icons.Default.Clear,
                    rightIconClicked = { nameInput = "" },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
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

                // Password Input Field
                CustomTextField(
                    textInput = passwordInput,
                    onChangeText = { newText -> passwordInput = newText },
                    placeholder = "Enter Your Password",
                    leftIcon = Icons.Default.Key,
                    rightIcon = Icons.Default.RemoveRedEye,
                    rightIconClicked = { passwordInput = "" },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
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
                            text = "Sign Up",
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

//            Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.weight(1f))
                // OR Sign In With
                Text(text = "Or Sign In with")

                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.weight(1f))
                // Social Login Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    val socialIcons = listOf(R.drawable.google, R.drawable.facebook, R.drawable.linkedin)
                    socialIcons.forEach { icon ->
                        Card(
                            modifier = Modifier
                                .width(100.dp)
                                .height(70.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background)
                            ) {
                                Image(
                                    painter = painterResource(icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f)) // Pushes the next Row to the bottom

                // Bottom "Sign Up" Text
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account?",
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    Text(
                        text = "Sign In Now",
                        modifier = Modifier.clickable {
                            navController.navigate("signin"){
                                popUpTo("signup") { inclusive=true }
                            }
                        },
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        WindowWidthSizeClass.Expanded ->     Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Added padding for better spacing
            ) {

                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight()
                ) {

                // Sign-In Image
                Image(
                    painter = painterResource(R.drawable.sign_up_pana),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth().fillMaxHeight(0.9f)
                )

                    // Bottom "Sign Up" Text
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Already have an account?",
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Text(
                            text = "Sign In Now",
                            modifier = Modifier.clickable {
                                navController.navigate("signin"){
                                    popUpTo("signup") { inclusive=true }
                                }
                            },
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight().padding(top = 10.dp)
                ) {
                // Email Input Field
                CustomTextField(
                    textInput = nameInput,
                    onChangeText = { newText -> nameInput = newText },
                    placeholder = "Enter Your Name",
                    leftIcon = Icons.Default.AccountCircle,
                    rightIcon = Icons.Default.Clear,
                    rightIconClicked = { nameInput = "" },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
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

                // Password Input Field
                CustomTextField(
                    textInput = passwordInput,
                    onChangeText = { newText -> passwordInput = newText },
                    placeholder = "Enter Your Password",
                    leftIcon = Icons.Default.Key,
                    rightIcon = Icons.Default.RemoveRedEye,
                    rightIconClicked = { passwordInput = "" },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
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
                            text = "Sign Up",
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

//            Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.weight(1f))
                // OR Sign In With
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Or Sign Up with")
                }

                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.weight(1f))
                // Social Login Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    val socialIcons = listOf(R.drawable.google, R.drawable.facebook, R.drawable.linkedin)
                    socialIcons.forEach { icon ->
                        Card(
                            modifier = Modifier
                                .width(100.dp)
                                .height(70.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                                    .background(MaterialTheme.colorScheme.background)
                            ) {
                                Image(
                                    painter = painterResource(icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                        }
                    }
                }


                }
            }
        }
    }


}