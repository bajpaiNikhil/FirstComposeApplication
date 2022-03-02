package com.example.firstcomposeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class lazyColumnInCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                val personRepository = PersonRepository()
                val getALlData = personRepository.getAllData()

                LazyColumn(contentPadding = PaddingValues(all = 12.dp) ,
                verticalArrangement = Arrangement.spacedBy(12.dp)){
//                    items(items = getALlData){ person ->
//                    CustomItem(person = person)
//                    }
                    itemsIndexed(items  = getALlData){index  , person ->
                        Log.d("MainActivity" , "value of the item is $index")
                        CustomItem(person = person)

                    }
                }



            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    FirstComposeApplicationTheme {
        val personRepository = PersonRepository()
        val getALlData = personRepository.getAllData()

        LazyColumn(contentPadding = PaddingValues(all = 12.dp) ,
            verticalArrangement = Arrangement.spacedBy(12.dp)){
//            items(items = getALlData){ person ->
//                CustomItem(person = person)
//            }
            itemsIndexed(items  = getALlData){index  , person ->
                Log.d("MainActivity" , "value of the item is $index")
                CustomItem(person = person)

            }
        }
    }
}