package com.example.firstcomposeapplication

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalFoundationApi
@Composable
fun StickyHeader(){
    val sections = listOf<String>("A" , "B" , "C" , "D" ,"E")

    LazyColumn(contentPadding = PaddingValues(all = 12.dp) ,
    verticalArrangement = Arrangement.spacedBy(12.dp)){
        sections.forEach{ section ->
            stickyHeader {
                Text( modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(12.dp),
                text = "iamstupid Section:$section")
            }
            items(10 ){
                Text(text = "Items $it from the section $section")
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun StickyHeaderPreview(){
    StickyHeader()
}