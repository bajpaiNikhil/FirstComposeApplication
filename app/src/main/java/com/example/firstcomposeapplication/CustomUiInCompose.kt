package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class CustomUiInCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview12() {
    FirstComposeApplicationTheme {

      Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
          var value by remember { mutableStateOf( 0)}

          CustomComponents(indicatorValue = value)
          TextField(value = value.toString()
              , onValueChange = {
                  value = if(it.isNotEmpty()){
                      it.toInt()
                  }else{
                      0
                  }
              } ,
              keyboardOptions = KeyboardOptions(
                  keyboardType = KeyboardType.Number
              )
          )
      }
    }
}