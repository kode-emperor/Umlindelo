package com.kodeemperor.umlindelo

import androidx.annotation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.TextStyle
import com.kodeemperor.umlindelo.ui.theme.*


@Composable
fun PrimaryAppCard( modifier: Modifier = Modifier)
{
    Card(
        shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = DirtyBlue,
            contentColor = Color.White
        ),
        modifier = modifier.padding(bottom = 20.dp)

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 40.dp)
        ){
            MainSettings()
            Filter(
                modifier = Modifier.padding(top = 50.dp, start = 30.dp)
            )
        }

    }

}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Column(
        modifier = modifier
    ){
        Text(
            text = stringResource(title),
            style = TextStyle.Default.copy( fontWeight = FontWeight.Bold, fontSize = 18.sp),
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()

    }
}

@Composable
fun Filter(
    modifier: Modifier = Modifier
) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ){
        TextField(value = text ,
            onValueChange = {
                text = it
            },
            textStyle = TextStyle().copy(
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp
            )
            ,
            placeholder = {
                Text(
                    text = "Search...", style = TextStyle.Default.copy(
                        fontWeight = FontWeight.Bold,
                        color = Gray100
                    )
                )
            }
            ,
            singleLine = true
            ,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "search icon",
                    tint = Color.White
                )
            },
            trailingIcon = {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors().copy(
                        containerColor = Gray100.copy(alpha = 0.15f)
                    ),
                    shape = RoundedCornerShape(90.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.FilterList,
                            contentDescription = "arrow down",
                            tint = DirtyBlue,
                            modifier = Modifier
                                .background(
                                    color = Gray100.copy(
                                        alpha = 0.23f
                                    ),
                                    shape = RoundedCornerShape(percent = 50)
                                )
                                .padding(all = 5.dp)
                            //.clip(shape = RoundedCornerShape(2.dp))
                        )
                        Text(
                            text = "Filters",
                            modifier = Modifier.padding(start = 10.dp),
                            style = TextStyle().copy(
                                color = Color.White
                            )
                        )
                    }
                }
            },

            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Gray100,
                cursorColor = Color.White,

                ),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()

        )
    }

}


@Composable
fun MainSettings(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()

    ){
        IconButton(
            onClick = {},
        ) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = "app menu")
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = {  },
                colors = ButtonDefaults.outlinedButtonColors(),
            ) {
                Text(
                    text = "Current Location",
                    style = TextStyle.Default.copy(color = Color.White),
                    modifier = Modifier.padding(end = 1.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "location lookup",
                    tint = Gray500
                )
            }
            Text("Revelation, Nottingham")
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "notifications")
        }
    }
}
