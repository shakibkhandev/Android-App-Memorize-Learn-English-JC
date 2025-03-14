package com.learn.memorize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.learn.memorize.ui.ViewModels.NavigationViewModel
import com.learn.memorize.ui.navigation.AppNavigation
import com.learn.memorize.ui.theme.MemorizeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemorizeTheme {
                Scaffold(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) { paddingValues ->
                    val windowSize = calculateWindowSizeClass(this).widthSizeClass
                    AppNavigation(modifier = Modifier.padding(paddingValues), windowSize = windowSize)
                }

            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MemorizeTheme {
//        Scaffold(
//            modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()
//        ) {
//            AppNavigation(modifier = Modifier.padding(it))
//        }

    }
}