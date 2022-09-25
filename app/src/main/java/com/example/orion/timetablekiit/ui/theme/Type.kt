package com.example.orion.timetablekiit.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.orion.timetablekiit.R

var font = FontFamily(
    Font(R.font.newfont , FontWeight.Bold)
)
val Typography = Typography(
 h1 = TextStyle(
     fontFamily = font,
     fontWeight = FontWeight.Normal,
     fontSize = 25.sp
 )
)