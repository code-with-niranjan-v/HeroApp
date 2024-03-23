package com.example.heroapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val Purple700 = Color(0xff7B1FA2)
val Purple500 = Color(0xff9C27B0)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)

val Colors.welcomeOnBoardScreenColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White

val Colors.titleColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else DarkGray

val Colors.descriptionColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray.copy(alpha = 0.5f)
    else DarkGray.copy(alpha = 0.5f)

val Colors.activeColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple500 else Purple700

val Colors.inActiveColor
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGray else LightGray

val Colors.buttonColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple500 else Purple700