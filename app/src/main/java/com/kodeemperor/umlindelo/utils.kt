package com.kodeemperor.umlindelo

import androidx.annotation.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.*
import java.time.*
import java.time.format.*

@Composable
fun OverlappingRow(
    modifier: Modifier = Modifier,
    overlappingPercentage: Float,
    content: @Composable () -> Unit
) {

    val factor = (1 - overlappingPercentage)

    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }
            val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
            val firstWidth = placeables.getOrNull(0)?.width ?: 0
            val width = (widthsExceptFirst * factor + firstWidth).toInt()
            val height = placeables.maxOf { it.height }
            layout(width, height) {
                var x = 0
                for (placeable in placeables) {
                    placeable.placeRelative(x, 0, 0f)
                    x += (placeable.width * factor).toInt()
                }
            }
        }
    )
}
///DATA HANDLING HERE ...





val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

val upcomingEventsData = listOf(
    Event(
        startDate = makeDateTime("01/06/2024 12:00:00"),
        endDate = makeDateTime("01/06/2024 14:00:00"),
        title = R.string.conference,
        location = EventLocation(
            host = R.string.revelations_church_in_zion,
            postCode = R.string.rev_postcode,
            address = R.string.rev_address
        ),
        eventImage = R.drawable.geometric_birds)
)


fun makeDateTime(dateTimeString: String):LocalDateTime {
    return LocalDateTime.parse(dateTimeString, dateTimeFormatter)
}
val testEvent = upcomingEventsData[0]
val testDate: LocalDate = LocalDate.parse("01/01/2024", dateFormatter)

 data class Event(
     val startDate: LocalDateTime,
     val endDate: LocalDateTime,
     @StringRes val title: Int,
     val location: EventLocation,
     @DrawableRes val eventImage: Int
)

data class EventLocation(
    @StringRes val host:  Int,
    @StringRes val postCode: Int,
    @StringRes val address: Int
)

fun LocalDate.print(): String {
    return "%s, %s %s, %s".format(
        this.dayOfWeek.name
            .take(3)
            .lowercase()
            .titlecase(),
        this.dayOfMonth.toString().dayOfTheMonthPluralizer(),
        this.month.name.lowercase().titlecase(),
        this.year
    )
}

fun LocalTime.print(): String {
    return "%02d:%02d %s".format(
        this.hour,
        this.second,
        if(this.isAfter(LocalTime.NOON) || (this == LocalTime.NOON)) "PM" else "AM"
    )
}
fun String.dayOfTheMonthPluralizer(): String {
    val pval =  when(this) {
        "1", "21", "31" -> "${this}st"
        "2","22" -> "${this}nd"
        else -> "${this}th"
    }
    return pval
}

fun String.titlecase():String {
    return this.replaceFirstChar { it.uppercase() }
}
