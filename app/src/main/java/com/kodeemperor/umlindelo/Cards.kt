package com.kodeemperor.umlindelo

import androidx.annotation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.kodeemperor.umlindelo.ui.theme.*
import java.time.*



@Composable
fun EventCard(event: Event, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.White
            )

    ){
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors().copy(
                containerColor = Color.White
            )
        ){
            Box {
                Image(
                    painter = painterResource(event.eventImage),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
                val dayOfTheMonth = event.startDate.dayOfMonth
                val month = event.startDate.month
                CardButtons(
                    dayOfTheMonth = dayOfTheMonth,
                    month = month
                )
            }
            EventCardDetails(event = event)
        }

    }
}

@Composable
fun CardButtons(
    dayOfTheMonth: Int,
    month: Month,
    modifier: Modifier = Modifier,
) {
    val buttonShape = RoundedCornerShape(10.dp)
    val buttonColors = ButtonDefaults.buttonColors().copy(
        containerColor = Gray100,
    )
    val contentColor = LightPink
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Button(
            onClick = {},
            shape = buttonShape,
            colors = buttonColors
        ) {
            Column {
                Text(text = dayOfTheMonth.toString(), style = TextStyle.Default.copy(
                    color = contentColor,
                    fontWeight = FontWeight.W900,
                    fontSize = 20.sp
                )
                )
                Text(
                    text = month.name.take(3).uppercase(),
                    style = TextStyle.Default.copy(
                        color = contentColor,
                        fontWeight = FontWeight.W300
                    )
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            shape = buttonShape,
            colors = buttonColors
        ) {
            Icon(imageVector = Icons.Filled.Bookmark, contentDescription = null, tint = contentColor)
        }
    }
}


@Composable
fun EventCardDetails(
    event: Event,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            .background(color = Color.White)
    ){
        Text(
            text = stringResource(event.title),
            style = TextStyle.Default.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ))
        OverlappingRow(overlappingPercentage = 0.4f, modifier = Modifier.padding(top = 16.dp)) {
            val imageModifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
            Image(painter = painterResource(R.drawable.pexels_holarbash),
                contentScale = ContentScale.Crop,
                contentDescription = null, modifier = imageModifier )

            Image(painter = painterResource(R.drawable.pexels_arman_heidary),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = imageModifier)
            Image(painter = painterResource(R.drawable.pexels_aderawilson),
                contentScale = ContentScale.Crop,
                contentDescription = null, modifier = imageModifier)
        }
        LocationDetails(location = stringResource(event.location.address))
    }
}
@Composable
fun ListCard(
    @DrawableRes cardImage: Int,
    startTime: LocalTime,
    endTime: LocalTime,
    address: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(10.dp)
            .height(intrinsicSize = IntrinsicSize.Min)
            .fillMaxWidth()
            .shadow(
                elevation = 0.9.dp,
                shape = RoundedCornerShape(10.dp),
                ambientColor = Gray100.copy(alpha = 0.5f)
            )
    ){

    }

}

@Composable
fun TimeLineCard(
    @DrawableRes cardImage: Int,
    startTime: LocalTime,
    endTime: LocalTime,
    address: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White,
            contentColor = Gray700
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
    ) {
        Row {
            Image(
                painter = painterResource(cardImage),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(10.dp)
                    .width(150.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp))
                //.background(color = Color.Transparent, shape = RoundedCornerShape(10.dp))

            )
            Column(
                modifier = Modifier
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .padding(10.dp)

            ){

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.height(intrinsicSize = IntrinsicSize.Min)
                ){
                    Text(
                        text = "%s - %s".format(startTime.print(), endTime.print()),
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = DirtyBlue
                        ),
                        modifier = Modifier.padding(top = 12.dp)
                    )

                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Bookmark,
                            contentDescription = null,
                            tint = LightPink
                        )
                    }
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )

                LocationDetails(
                    address.take(20).padEnd(23,'.'),
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
        }
    }
}

@Composable
fun LocationDetails(
    location: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.LocationOn,
            contentDescription = null,
            tint = Gray400
        )

        Text(
            text = location,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Gray400
            ),
            modifier = Modifier.padding(start = 10.dp, top = 4.dp)
        )
    }
}

@Composable
fun CircularButton(
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        colors = buttonColors,
        modifier = modifier
            .size(size)
            .clip(
                shape = CircleShape
            )
    ) {
        content()
    }
}

@Composable
fun TimeLineDate(
    modifier: Modifier = Modifier,
    date: LocalDate = testDate
)  {
    val contentColor = DirtyBlue
    val buttonColors = ButtonDefaults.buttonColors().copy(
        containerColor = contentColor.copy(alpha = 0.065f),
    )



    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        CircularButton(
            size = 56.dp,
            buttonColors = buttonColors,
            onClick = { /*TODO*/ },
            modifier = modifier
        ) {
            Column {
                Text(
                    text = date.dayOfMonth.toString(),
                    style = TextStyle.Default.copy(
                        color = contentColor,
                        fontWeight = FontWeight.W900,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = date.month.name.take(3),
                    style = TextStyle.Default.copy(
                        color = contentColor,
                        fontWeight = FontWeight.W300
                    )
                )
            }
        }

        Text(
            text = date.print(),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(start = 20.dp, top = 15.dp)
        )

    }
}
