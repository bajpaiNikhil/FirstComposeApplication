package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class passwordTextFieldInCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting6()
                }
            }
        }
    }
}

@Composable
fun Greeting6() {
    Column(modifier = Modifier.fillMaxSize() ,
    horizontalAlignment = Alignment.CenterHorizontally ,
    verticalArrangement = Arrangement.Center)
    {
        var password  by rememberSaveable{ mutableStateOf("") }
        var visibilityPassword by remember { mutableStateOf( false)}

        val icon = if(visibilityPassword)
            painterResource(id = R.drawable.ic_baseline_visibility_24)
        else painterResource(id = R.drawable.ic_baseline_visibility_off_24)

        OutlinedTextField(value = password, onValueChange ={
            password = it
        } ,
            placeholder = {Text(text = "Password")},
            label = {Text(text = "Password")}
                , trailingIcon = {
                    IconButton(onClick = {
                        visibilityPassword = !visibilityPassword
                    }) {
                        Icon(painter = icon
                            , contentDescription = "visible")
                    }
            } ,
            keyboardOptions =  KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if(visibilityPassword) VisualTransformation.None else PasswordVisualTransformation() ,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    FirstComposeApplicationTheme {
        Greeting6()
    }
}