package com.kodeemperor.umlindelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import com.kodeemperor.umlindelo.ui.theme.*
import java.time.*
import java.time.format.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UmlindeloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        val event = upcomingEventsData[0]
        PrimaryAppCard()
        //EventCardDetails(event = testEvent)

        LazyColumn {
            item {
                HomeSection(title = R.string.upcoming_event_title) {
                    EventCard(
                        event = event,
                        modifier =
                        Modifier.padding(10.dp)
                    )
                }
                val startTime = event.startDate.toLocalTime()
                val endTime = event.endDate.toLocalTime()

                TimeLineDate(
                    date = event.startDate.toLocalDate(),
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(top = 10.dp)
                )
                TimeLineCard(
                    cardImage = event.eventImage,
                    startTime = startTime,
                    endTime = endTime,
                    address = stringResource(event.location.address),
                    title = stringResource(event.title),
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}
