package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class TextCustomizationInCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {

    Text(text = stringResource(id = R.string.app_name) ,
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
            .width(500.dp),
        color = Color.White ,
        fontSize = 20.sp ,
        fontStyle = FontStyle.Italic ,
        fontWeight = FontWeight.ExtraBold ,
        textAlign = TextAlign.End
    )
}

@Composable
fun CustomTextWithAnnotatedStr(){
    Text(
        buildAnnotatedString {

            withStyle(style = ParagraphStyle(
                textAlign = TextAlign.Center
            )){
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colors.primary
                    , fontWeight = FontWeight.ExtraBold
                    , fontSize = MaterialTheme.typography.h6.fontSize
                    , fontStyle = FontStyle.Italic
                    , fontFamily = FontFamily.Cursive

                )){
                    append("I") // can be applied to a single character
                }

                append("A")
                append("M")
                append("S")
                append("T")
                append("U")
                append("P")
                append("I")
                append("D")
            }
        } ,  modifier = Modifier.width(300.dp)
    )
}


@Composable
fun CustomText3(){
    Text(text = "IamStupid".repeat(20) , maxLines =  2 , overflow = TextOverflow.Ellipsis)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    FirstComposeApplicationTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CustomText3()
        }

    }
}