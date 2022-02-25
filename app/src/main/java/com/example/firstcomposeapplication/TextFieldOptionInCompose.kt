package com.example.firstcomposeapplication


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TextFieldInCompose(){
    Column(modifier  = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background),
    horizontalAlignment = Alignment.CenterHorizontally  ,
    verticalArrangement = Arrangement.Center ,
    )
    {
        var text by remember { mutableStateOf("TypeHere") }
        OutlinedTextField(value = text , onValueChange ={ newText ->
            text = newText
        } ,
//            readOnly = true // wont be able to type anything
//            enabled = false , // text filed will be out of focus 
        label = {
            Text(text = "Title")
        } ,
//        singleLine = true
//        maxLines = 2 
        leadingIcon = {
            IconButton(onClick = {
                Log.d("TextImage" , "EmailIconClicked")
            }) {
                Icon(imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon ")
            }
        } ,
            trailingIcon = {
                IconButton(onClick = {
                    Log.d("TextImage" , "CheckIconClicked")
                }) {
                    Icon(imageVector = Icons.Default.CheckCircle,
                        contentDescription = "check item")
                }
            } ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email ,
                imeAction = ImeAction.Search //changes the search /ime action button
            ) ,
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d("TextImage" , "Search Icon i.e ime action button is clicked")
                }
            )
        )
    }

}

@Composable
@Preview
fun TextFieldInComposePreview(){
    TextFieldInCompose()
}