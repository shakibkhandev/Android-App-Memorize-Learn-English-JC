package com.learn.memorize.ui.screens.authentication

import android.content.res.Configuration
import android.media.Image
import android.widget.Spinner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.learn.memorize.R
import com.learn.memorize.ui.theme.MemorizeTheme



@Composable
fun SignInScreen(navController: NavController, modifier: Modifier = Modifier, windowSize: WindowWidthSizeClass) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }


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
                    painter = painterResource(R.drawable.sign_in_pana),
                    contentDescription = null,
                    modifier = modifier.fillMaxWidth()
                )

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
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Forget Password ?",
                        modifier = modifier.clickable {
                            navController.navigate("forgetpassword")
                        },
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                // Sign-In Button
                ElevatedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Sign In",
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

//            Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.weight(1f))
                // OR Sign In With
                Text(text = "Or Sign In with")

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
                        text = "Don't have an account?",
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    Text(
                        text = "Sign Up Now",
                        modifier = Modifier.clickable {
                            navController.navigate("signup"){
                                popUpTo("signin") { inclusive=true }
                            }
                        },
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        WindowWidthSizeClass.Expanded ->     Box(modifier = Modifier.fillMaxSize()) {
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(R.drawable.sign_in_pana),
                        contentDescription = null,
                        modifier = modifier.fillMaxWidth().fillMaxHeight(0.9f)
                    )
                    // Bottom "Sign Up" Text
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Don't have an account?",
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Text(
                            text = "Sign Up Now",
                            modifier = Modifier.clickable {
                                navController.navigate("signup"){
                                    popUpTo("signin") { inclusive=true }
                                }
                            },
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                // Sign-In Image
               Column(
                   modifier = Modifier.weight(1f).fillMaxHeight().padding(top = 10.dp)
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
                   Row(
                       modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.End
                   ) {
                       Text(
                           text = "Forget Password ?",
                           modifier = modifier.clickable {
                               navController.navigate("forgetpassword")
                           },
                           fontSize = 12.sp,
                           color = MaterialTheme.colorScheme.primary
                       )
                   }
                   Spacer(modifier = Modifier.height(20.dp))

                   // Sign-In Button
                   ElevatedButton(
                       onClick = {},
                       modifier = Modifier.fillMaxWidth(),
                       shape = RoundedCornerShape(12.dp)
                   ) {
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Text(
                               text = "Sign In",
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
                    ){
                        Text(text = "Or Sign In with")

                    }
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



@Composable
fun CustomTextField(
    textInput: String,
    onChangeText: (String) -> Unit,
    placeholder: String,
    leftIcon: ImageVector,
    rightIcon: ImageVector,
    rightIconClicked: () -> Unit,
    keyboardOptions: KeyboardOptions
) {
    BasicTextField(
        value = textInput,
        onValueChange = { onChangeText(it) },
        keyboardOptions = keyboardOptions,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(12.dp))
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 16.sp
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = leftIcon,
                    contentDescription = "Left Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.weight(1f)) {
                    if (textInput.isEmpty()) {
                        Text(
                            text = placeholder,  // Use the placeholder text
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
                // Display the right icon only if the text is not empty
                if (textInput.isNotEmpty()) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = rightIcon,
                        contentDescription = "Clear Text",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { rightIconClicked() }  // Ensure rightIconClicked is used here
                    )
                }
            }
        }
    )
}





@Preview(showBackground = true)
@Composable
fun PreviewScreen(){
    MemorizeTheme {
//        SignInScreen(navController = rememberNavController(), windowSize = WindowWidthSizeClass = calculateWindowSizeClass(this))
    }
}
