package com.learn.memorize.ui.screens.main

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.memorize.R
import com.learn.memorize.ui.theme.MemorizeTheme
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.time.ZoneId
import java.util.Calendar
import java.util.Date
import java.util.Locale


@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
    ) {
        // Using Box to overlap images
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp) // Limit height of the Box
        ) {
            // First (larger) image
            Image(
                painter = painterResource(R.drawable.english_teacher_pana),
                contentDescription = "Profile Image",
                modifier = modifier
                    .fillMaxWidth()
            )

            // Second (circular) image
            Image(
                painter = painterResource(R.drawable._725859258742),
                contentDescription = "Profile Image",
                modifier = modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomStart),
                contentScale = ContentScale.Crop
            )
            OutlinedButton(
                onClick = {},
                modifier = modifier.height(40.dp).align(Alignment.BottomEnd).background(MaterialTheme.colorScheme.background)
            ) {
                Text(
                    text = "Edit Profile"
                )
            }
        }

        // Space between the images and the profile text
        Spacer(modifier = Modifier.height(10.dp))

       Row(
           modifier = modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween
       ) {
           // Example profile name text
          Column(

          ) {
              Text(
                  text = "Shakib Khan",
                  style = MaterialTheme.typography.titleMedium, // Improved typography style
                  modifier = modifier
              )
              Text(
                  text = "@shakibkhandev",
                  style = MaterialTheme.typography.titleMedium, // Improved typography style
                  modifier = modifier
                      .graphicsLayer (alpha = 0.5f)
              )
          }

       }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Who am i going to lose if in my worst moments i was always alone",
            modifier = modifier.graphicsLayer(alpha = 0.8f),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = modifier
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp) // Space between the icon and text
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocalLibrary,
                        contentDescription = null,
                        modifier = modifier.size(15.dp)
                    )

                    // Text
                    Text(
                        text = "Student",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Box(
                modifier = modifier
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp) // Space between the icon and text
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = null,
                        modifier = modifier.size(15.dp)
                    )

                    // Text
                    Text(
                        text = "Sylhet, Bangladesh",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = modifier
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp) // Space between the icon and text
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Badge,
                        contentDescription = null,
                        modifier = modifier.size(15.dp)
                    )

                    // Text
                    Text(
                        text = "Born January 2, 2009",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Box(
                modifier = modifier
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp) // Space between the icon and text
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CalendarMonth,
                        contentDescription = null,
                        modifier = modifier.size(15.dp)
                    )

                    // Text
                    Text(
                        text = "Joined july, 2024",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        SimpleCalendarView(
            onDateSelected = {}
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Your Activities",
            modifier = modifier,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))
            Column (
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

              repeat(10){
                  Column(
                      modifier = modifier.fillMaxWidth()
                  ) {
                      Text("Learning Path - 01")
                      Spacer(modifier = Modifier.height(5.dp))
                      LinearProgressIndicator(
                          progress = { 0.5f },
                          modifier = Modifier.fillMaxWidth(),
                      )
                  }
              }

            }


    }
}


@Composable
fun SimpleCalendarView(
    initialDate: Date = Date(),
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentCalendar by remember { mutableStateOf(Calendar.getInstance().apply {
        time = initialDate
        set(Calendar.DAY_OF_MONTH, 1)
    }) }

    val calendar = Calendar.getInstance().apply {
        time = currentCalendar.time
        set(Calendar.DAY_OF_MONTH, 1)
    }

    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1 // Sunday 0, Saturday 6

    val monthYearFormatter = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    val fullDateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    val dates = (1..daysInMonth).map { day ->
        calendar.set(Calendar.DAY_OF_MONTH, day)
        fullDateFormatter.format(calendar.time)
    }

    val monthYearText = monthYearFormatter.format(calendar.time).replaceFirstChar { it.uppercase() }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = monthYearText,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
            Row {
                IconButton(onClick = {
                    currentCalendar.add(Calendar.MONTH, -1)
                    currentCalendar = Calendar.getInstance().apply { time = currentCalendar.time }
                    currentCalendar.set(Calendar.DAY_OF_MONTH, 1)
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Previous Month")
                }
                IconButton(onClick = {
                    currentCalendar.add(Calendar.MONTH, 1)
                    currentCalendar = Calendar.getInstance().apply { time = currentCalendar.time }
                    currentCalendar.set(Calendar.DAY_OF_MONTH, 1)
                }) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Next Month")
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 4.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            val totalSlots = firstDayOfMonth + daysInMonth
            val weeks = (totalSlots + 6) / 7 // Ceiling division to get number of weeks
            val allDays = (0 until weeks * 7).map { index ->
                if (index < firstDayOfMonth || index >= firstDayOfMonth + daysInMonth) null
                else dates[index - firstDayOfMonth]
            }

            allDays.chunked(7).forEach { weekDays ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    weekDays.forEach { date ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .size(48.dp)
                                .clickable(enabled = date != null) { date?.let { onDateSelected(it) } },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = date?.split("-")?.get(2) ?: "",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen()
}
