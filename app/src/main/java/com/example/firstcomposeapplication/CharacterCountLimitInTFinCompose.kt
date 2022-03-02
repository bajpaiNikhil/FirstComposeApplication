package com.example.firstcomposeapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LimitCharCount(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var name by remember { mutableStateOf("")}
        val maxChar = 10


        OutlinedTextField(
            value = name,
            onValueChange ={
                if (it.length<=maxChar) name = it}  ,
            label = { Text(text =  "Name")} ,
            placeholder = {Text(text = "Enter your name my G")} ,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun LimitCharCountPreview(){
    LimitCharCount()
}


