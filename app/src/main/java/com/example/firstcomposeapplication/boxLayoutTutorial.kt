package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class boxLayoutTutorial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        contentAlignment = Alignment.Center
        ){
        Box(modifier = Modifier
            .background(Color.White)
            .width(100.dp)
            .height(100.dp)
            .verticalScroll(rememberScrollState())) {
                Text(text = "IamStupid you are stupid . ", fontSize = 50.sp)
            }
    }
    Box(modifier = Modifier
        .background(Color.Green)
        .width(100.dp)
        .height(100.dp)
        .horizontalScroll(rememberScrollState()),
        contentAlignment = Alignment.TopCenter){
        Text(text = "IamStupid" , fontSize = 40.sp)
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FirstComposeApplicationTheme {
        Greeting()
    }
}