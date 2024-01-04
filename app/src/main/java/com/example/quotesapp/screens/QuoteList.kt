package com.example.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotesapp.model.Quote

@Composable
fun quoteList(data: Array<Quote>,onClick:(quote: Quote)->Unit) {
    
    LazyColumn(content = {
        items(data){
            quoteListItem(quote = it,onClick)
        }
    })
    
}