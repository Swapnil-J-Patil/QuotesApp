package com.example.quotesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.R
import com.example.quotesapp.model.Quote

@Composable
fun homeScreen(data: Array<Quote>,onClick:(quote: Quote)->Unit) {

    Column(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.navyblue),
                        colorResource(id = R.color.darkpurple)
                    )
                )
            )
    ) {
        Text(
            text = "Quotopia",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp,16.dp)
                .fillMaxWidth(1f),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            style = TextStyle(
                Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.purple),
                        colorResource(id = R.color.pink),
                        colorResource(id = R.color.white),

                        )
                )
            )
        )
        
        quoteList(data = data,onClick)
    }
}