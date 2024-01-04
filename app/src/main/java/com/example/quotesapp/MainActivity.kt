package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.quotesapp.data.DataManager
import com.example.quotesapp.screens.homeScreen
import com.example.quotesapp.screens.quoteDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        //First app will read the json file
        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun app() {

    //If data is loaded then show quoteList screen
    if(DataManager.isDataLoaded.value)
    {
        if(DataManager.currentPage.value==Pages.LISTING)
        {
            homeScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }
        else
        {
            DataManager.currentQuote?.let { quoteDetail(quote = it) }
        }
    }
    else
    {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}
