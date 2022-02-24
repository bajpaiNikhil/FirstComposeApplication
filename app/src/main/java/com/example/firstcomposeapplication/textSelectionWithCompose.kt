package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class textSelectionWithCompose : ComponentActivity() {
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
fun CustomTextForSelection() {

    SelectionContainer {
        Column() {

            Text(text = "IamStupid!!!!!!!!!!".repeat(20))
            DisableSelection {
                Text(text = "WeAreStupid!!!!!!!!!!")
            }

            Text(text = "IamStupid!!!!!!!!!!".repeat(20))


        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    FirstComposeApplicationTheme {
        CustomTextForSelection()
    }
}