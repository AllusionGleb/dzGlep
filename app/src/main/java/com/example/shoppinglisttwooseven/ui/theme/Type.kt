package com.example.shoppinglisttwooseven.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Определение набора типографических стилей Material для использования в приложении
val Typography = Typography(
    // Основной текст (bodyLarge) с заданными стилями
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Использование стандартного семейства шрифтов
        fontWeight = FontWeight.Normal,   // Нормальная жирность шрифта
        fontSize = 16.sp,                 // Размер шрифта 16sp
        lineHeight = 24.sp,               // Высота строки 24sp
        letterSpacing = 0.5.sp            // Межбуквенное расстояние 0.5sp
    )
    /* Другие стандартные текстовые стили, которые можно переопределить
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default, // Использование стандартного семейства шрифтов
        fontWeight = FontWeight.Normal,   // Нормальная жирность шрифта
        fontSize = 22.sp,                 // Размер шрифта 22sp
        lineHeight = 28.sp,               // Высота строки 28sp
        letterSpacing = 0.sp               // Межбуквенное расстояние 0sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default, // Использование стандартного семейства шрифтов
        fontWeight = FontWeight.Medium,   // Средняя жирность шрифта
        fontSize = 11.sp,                 // Размер шрифта 11sp
        lineHeight = 16.sp,               // Высота строки 16sp
        letterSpacing = 0.5.sp            // Межбуквенное расстояние 0.5sp
    )
    */
)