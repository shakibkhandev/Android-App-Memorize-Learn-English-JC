package com.learn.memorize.ui.screens.main

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.learn.memorize.R

@Composable
fun DiscoveryScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .horizontalScroll(rememberScrollState())
                .padding(WindowInsets.statusBars.asPaddingValues()),
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Adjust the space between items
            verticalAlignment = Alignment.CenterVertically // Optional: Align vertically
        ) {
            repeat(20) {
                AssistChip(
                    onClick = { Log.d("Assist chip", "hello world") },
                    label = { Text("Assist chip") },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = "Localized description",
                            Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }
                )
            }
        }
        Column(
            modifier =  modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            repeat(20){
                DiscoveryContentItems(modifier = modifier)
            }
        }
    }
}

@Composable
fun DiscoveryContentItems(modifier: Modifier = Modifier) {

    // Card with rounded corners and soft shadow
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 2.dp),
        elevation = CardDefaults.cardElevation(10.dp),

        shape = RoundedCornerShape(6.dp),  // Rounded corners for modern design
    ) {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            // Row for Learning Path Name (Main Title) and Chevron Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,  // Space between title and icon
                verticalAlignment = Alignment.CenterVertically  // Align vertically to center
            ) {
                // Column for Text content (Learning Path Name and Description)
                Column(
                    modifier = modifier.fillMaxSize(0.7f).padding(10.dp)
                ) {
                    // Learning Path Name (Main Title)
                    Text(
                        text = "Learning Path: Fundamentals of Programming",
                        style = MaterialTheme.typography.titleSmall.copy(  // Use titleMedium for a bold title
                            fontWeight = FontWeight.Bold,  // Emphasized title
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        modifier = Modifier.padding(bottom = 8.dp),
                    )

                    // Learning Path Description (Subtext)
                    Text(
                        text = "A comprehensive learning path to get started with programming, covering the basics of syntax, algorithms, and problem-solving skills.",
                        style = MaterialTheme.typography.bodySmall.copy(  // Body text, medium weight
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)  // Slight opacity for better readability
                        ),
                        modifier = Modifier.padding(bottom = 16.dp)  // Padding below the description
                    )
                }

                // Spacer to create flexible space between content and the icon
                Spacer(modifier = modifier.weight(1f))

                // Chevron Icon (or Image) to represent action, placed on the right side
                Column(
                    modifier = modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.english_teacher_pana), // Replace with your actual image resource
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
