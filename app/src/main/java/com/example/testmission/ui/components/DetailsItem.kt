package com.example.testmission.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsItem(
    title : String,
    desc : String
) {

    Spacer(modifier = Modifier.size(4.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            color = Color.White,
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.W500)
        Text(
            color = Color.White,
            text = desc,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.W600,
        )
    }
}