package com.example.firstcomposeapplication


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.theme.color1
import com.example.firstcomposeapplication.ui.theme.color2

@Composable
fun GradientButton(
    text: String,
    textColor : Color,
    gradient : Brush,
    onCLick:() -> Unit
    
){
    
    Button(colors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent
    ),
        contentPadding = PaddingValues()
        ,onClick = onCLick) {
        Box(modifier = Modifier
            .background(gradient)
            .padding(horizontal = 8.dp, vertical = 16.dp) ,
        contentAlignment = Alignment.Center){
            Text(text = text  , color = textColor)
        }
    }
}

@Preview
@Composable
fun GradientPreviewButton(){
    GradientButton(text = "IamStupid"
        , textColor = Color.White
        , gradient =Brush.horizontalGradient(listOf(
            color1, color2
        ))  ) {

    }
}