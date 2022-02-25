package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

@ExperimentalMaterialApi
class ExpandableCardWithCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp) ,
                    color = MaterialTheme.colors.background
                ) {
                   ExpandableCard(title = "IamStupid" , description = "WeAreStupid")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    //outLinedTextField -> draws outline for the text bos
    //basicTextField -> donesn't draw anything

}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    FirstComposeApplicationTheme {
        ExpandableCard(title = "IamStupid" , description = "WeAreStupid")
    }
}