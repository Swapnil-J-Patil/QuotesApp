package com.example.quotesapp.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.Pages
import com.example.quotesapp.model.Quote
import com.google.gson.Gson

data class QuotesResponse(val quotes: List<Quote>)

object DataManager {

    var data = emptyArray<Quote>()
    var currentPage=mutableStateOf(Pages.LISTING)
    var currentQuote:Quote?= null
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()

        // Use the QuotesResponse class to represent the outer structure
        val quotesResponse = gson.fromJson(json, QuotesResponse::class.java)

        // Extract the list of quotes from the QuotesResponse
        data = quotesResponse.quotes.toTypedArray()
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?=null){
        if(currentPage.value== Pages.LISTING)
        {
            currentQuote =quote
            currentPage.value = Pages.DETAIL
        }
        else
        {
            currentPage.value = Pages.LISTING

        }
    }
}
