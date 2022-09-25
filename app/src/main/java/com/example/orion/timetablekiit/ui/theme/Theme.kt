package com.example.orion.timetablekiit.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    background = Cyan900,
    surface = Cyan700,
    onSurface = Cyan900,
    primary = Grey50,
    onPrimary = Teal200,
    secondary = White
)

@Composable
fun TimeTableKIITTheme(
    content: @Composable () -> Unit
) {

     var colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}