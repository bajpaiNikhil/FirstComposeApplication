package com.example.firstcomposeapplication

import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.theme.Shapes


@ExperimentalMaterialApi
@Composable
fun signUpWithGoogleButton(
    text : String = "Sign Up with Google" ,
    loadingText : String = "Creating Account !!!! "
){

    var clicked by remember {mutableStateOf(false)}


    Surface(
        modifier = Modifier.animateContentSize(
            animationSpec = tween(
                durationMillis = 300 ,
                easing = LinearOutSlowInEasing
            )
        ),
        onClick = { clicked  = !clicked } ,
        shape =  Shapes.medium ,
        border = BorderStroke(1.dp , color = Color.LightGray ) ,
        color =  MaterialTheme.colors.surface ,

    ) {

        Row(
            //for padding to read from material.io for the button

            modifier = Modifier.padding(
                start = 12.dp, end = 16.dp ,top = 12.dp , bottom = 12.dp

            ),

            verticalAlignment = Alignment.CenterVertically  ,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(
                id = R.drawable.google_icon ) ,
                contentDescription = "Google icon" ,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(clicked) loadingText else text )
            if (clicked){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp) ,
                    strokeWidth = 2.dp ,
                    color = MaterialTheme.colors.primary
                )
            }
        }


    }
}


@ExperimentalMaterialApi
@Composable
@Preview
fun GooglePreviewButton(){
    signUpWithGoogleButton()
}