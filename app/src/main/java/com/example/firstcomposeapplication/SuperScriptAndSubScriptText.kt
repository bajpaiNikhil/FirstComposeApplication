package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class SuperScriptAndSubScriptText : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun SuperScriptText(
    normalText : String ,
    normalFontSize : TextUnit = MaterialTheme.typography.subtitle1.fontSize ,
    superScript : String ,
    superFontSize : TextUnit = MaterialTheme.typography.overline.fontSize
) {
    Text( buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = normalFontSize
        )){
            append(normalText)
        }
        withStyle(style = SpanStyle(
            fontSize  = superFontSize
        , fontWeight =  FontWeight.Normal
        , baselineShift = BaselineShift.Superscript
        )){
            append(superScript)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    FirstComposeApplicationTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            SuperScriptText(normalText = "Iam",40.sp ,  superScript = "Stupid!!!!!!")
            
        }
    }
}