package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.model.Quote

@Composable
fun homeScreen(data: Array<Quote>,onClick:(quote: Quote)->Unit) {

    Column() {
        Text(
            text = "Quotopia",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp,16.dp)
                .fillMaxWidth(1f),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        
        quoteList(data = data,onClick)
    }
}