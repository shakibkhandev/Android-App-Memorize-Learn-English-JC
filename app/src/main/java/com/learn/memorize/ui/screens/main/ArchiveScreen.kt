package com.learn.memorize.ui.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.learn.memorize.R

@Composable
fun ArchiveScreen(modifier: Modifier = Modifier, windowSize: WindowWidthSizeClass) {
    when(windowSize){
        WindowWidthSizeClass.Compact ->   Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            // Display Lottie Animation
            LottieAnimationLoad()
            Spacer(modifier = modifier.height(50.dp))
            repeat(10){
                LearningPathContent(modifier=modifier)
            }

        }
        WindowWidthSizeClass.Expanded ->   Row (
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                // Display Lottie Animation
                LottieAnimationLoad()
            }
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight().verticalScroll(rememberScrollState()).padding(
                    WindowInsets.statusBars.asPaddingValues()
                )
            ) {
                repeat(10){
                    LearningPathContent(modifier=modifier)
                }
            }

        }
    }

}

@Composable
fun LearningPathContent(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    // Card with rounded corners and soft shadow
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        shape = RoundedCornerShape(16.dp),  // Rounded corners for modern design
        elevation = CardDefaults.cardElevation(8.dp),  // Soft shadow effect
    ) {
        Column(
            modifier = Modifier.padding(16.dp)  // Padding around content
        ) {
            // Row for Learning Path Name (Main Title) and Chevron Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,  // Space between title and icon
                verticalAlignment = Alignment.CenterVertically  // Align vertically to center
            ) {
                // Learning Path Name (Main Title)
                Text(
                    text = "Learning Path: Fundamentals of Programming",
                    style = MaterialTheme.typography.titleMedium.copy(  // Use titleMedium for a bold title
                        fontWeight = FontWeight.Bold,  // Emphasized title
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Chevron Icon to expand/collapse the content
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    tint = MaterialTheme.colorScheme.secondary,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            expanded = !expanded  // Toggle the expanded state when clicked
                        }
                        .padding(start = 8.dp)  // Padding around the icon
                )
            }

            // Learning Path Description (Subtext)
            Text(
                text = "A comprehensive learning path to get started with programming, covering the basics of syntax, algorithms, and problem-solving skills.",
                style = MaterialTheme.typography.bodyMedium.copy(  // Body text, medium weight
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)  // Slight opacity for better readability
                ),
                modifier = Modifier.padding(bottom = 16.dp)  // Padding below the description
            )

            // Expanded Content Section
            if (expanded) {
                Column(
                    modifier = Modifier.padding(start = 16.dp)  // Indented content
                ) {
                    // Content Title (Steps)
                    Text(
                        text = "Content:",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // List of Steps
                    listOf(
                        "Learn basic programming concepts like variables, loops, and conditionals.",
                        "Understand the fundamentals of object-oriented programming.",
                        "Practice writing simple programs and solving problems."
                    ).forEach { step ->
                        Text(
                            text = step,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)  // Slight opacity for better contrast
                            ),
                            modifier = Modifier
                                .padding(bottom = 8.dp)  // Padding between each step
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun LottieAnimationLoad() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.learningpath))

    val progress by animateLottieCompositionAsState(
        isPlaying = true,
        composition = composition,
        iterations = LottieConstants.IterateForever,
        speed = 0.6f
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Adjust padding to make the animation fit better
    ) {
     LottieAnimation(
         composition = composition,
         progress = {progress}
     )
    }
}
