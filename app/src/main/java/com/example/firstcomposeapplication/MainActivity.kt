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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme
import com.example.firstcomposeapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color  = MaterialTheme.colors.background){
                    
                }
                
            }
        }
    }
}



@Composable
fun CustomText(test : String){
    Text(
        text = test ,
        style = Typography.h5

    )
}
@Composable
fun ColumnScope.CustomItem(weight : Float , color : Color =  MaterialTheme.colors.onSecondary){
    Surface(modifier = Modifier
        .width(260.dp)
        .weight(weight) ,
        color =  color
    ) {}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeApplicationTheme {

        Column(
            modifier = Modifier.fillMaxSize() ,
            horizontalAlignment = Alignment.CenterHorizontally ,
        ){
            CustomItem(weight = 3f, color = MaterialTheme.colors.primary)
            CustomItem(weight = 5f, color = MaterialTheme.colors.secondary)
            CustomItem(weight = 1f)
        }
    }
}