package com.example.globewise.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,         // Main white color for dark theme
    secondary = Color(0x80FFFFFF), // Faded white (50% opacity)
    tertiary = Color(0xB3FFFFFF),  // Slightly less faded white (70% opacity)

    background = Color.Black,      // Black background
    surface = Color(0xFF1C1C1C),   // Muted black surface
    onPrimary = Color.Black,       // Black text/icons on primary white
    onSecondary = Color.Black,     // Black text/icons on faded white
    onTertiary = Color.Black,      // Black text/icons on tertiary
    onBackground = Color.White,    // White text/icons on black background
    onSurface = Color.White        // White text/icons on black surface
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Black,         // Main black color for light theme
    secondary = Color(0x80000000), // Faded black (50% opacity)
    tertiary = Color(0xB3000000),  // Slightly less faded black (70% opacity)

    background = Color.White,      // White background
    surface = Color(0xFFF5F5F5),   // Light gray surface
    onPrimary = Color.White,       // White text/icons on primary black
    onSecondary = Color.White,     // White text/icons on faded black
    onTertiary = Color.White,      // White text/icons on tertiary
    onBackground = Color.Black,    // Black text/icons on white background
    onSurface = Color.Black        // Black text/icons on light surface
)

@Composable
fun GlobeWiseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}