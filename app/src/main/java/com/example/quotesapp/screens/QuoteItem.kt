package com.example.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.R
import com.example.quotesapp.model.Quote

@Composable
fun quoteListItem(quote: Quote,onClick: (quote: Quote)->Unit)
{
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(quote)
//when this function is called it will pass the current quote to parent
            }
            .fillMaxWidth(),
        
    ) {
        Box (
            modifier = Modifier.fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.pink),
                            colorResource(id = R.color.purple)
                        )
                    )
                )
        ){
            Row(
                Modifier.padding(10.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_format_quote_24),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                    alignment = Alignment.TopStart,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(40.dp)
                        .background(color = Color.Black)
                        .rotate(180f)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Column(
                    modifier = Modifier.weight(1f)
                    //now col will take all the remaining portion
                ) {
                    Text(
                        text = quote.quote,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color.Gray)
                            .fillMaxWidth(.4f)
                            .height(1.dp)
                    )
                    Text(
                        text = quote.author,
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 20.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.End,
                    )

                }
            }
        }
    }
}

