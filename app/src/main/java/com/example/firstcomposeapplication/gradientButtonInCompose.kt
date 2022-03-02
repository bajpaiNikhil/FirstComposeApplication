package com.example.firstcomposeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme
import com.example.firstcomposeapplication.ui.theme.color1
import com.example.firstcomposeapplication.ui.theme.color2

class gradientButtonInCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center ,
                verticalAlignment = Alignment.CenterVertically) {
                    GradientButton(text = "IamStupid"
                        , textColor = Color.White
                        , gradient = Brush.horizontalGradient(listOf(
                            color1, color2
                        ))  ){
                        Log.d("GB","buttonpressed")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting7(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    FirstComposeApplicationTheme {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.CenterVertically) {
            GradientButton(text = "IamStupid"
                , textColor = Color.White
                , gradient = Brush.horizontalGradient(listOf(
                    color1, color2
                ))  ){
                Log.d("GB","buttonpressed")
            } 
            Button(onClick = { /*TODO*/ }) {
                Text(text = "iamStupid")
                
            }
        }
    }
}