package com.example.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.data.DataManager
import com.example.quotesapp.R
import com.example.quotesapp.model.Quote

@Composable
fun quoteDetail(quote: Quote) {

    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.navyblue),
                        colorResource(id = R.color.darkpurple)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp),
            modifier = Modifier
                .padding(32.dp)
        ) {
            Box (
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                colorResource(id = R.color.pink),
                                colorResource(id = R.color.purple)
                            )
                        )
                    )
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(16.dp, 24.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_format_quote_24),
                        contentDescription = "",
                        alignment = Alignment.TopStart,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(80.dp)
                            .rotate(180f)
                    )
                    Text(
                        text = quote.quote,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                    )
                    Spacer(modifier = Modifier.padding(4.dp))

                    Text(
                        text = quote.author,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.End,
                    )
                }
            }
        }
    }
}

