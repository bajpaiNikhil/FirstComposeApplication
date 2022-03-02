package com.example.firstcomposeapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomItem(person: Person){
    Row(modifier = Modifier
        .background(Color.LightGray)
        .fillMaxWidth()
        .padding(24.dp) ,
    verticalAlignment = Alignment.CenterVertically ,
    horizontalArrangement = Arrangement.spacedBy(12.dp))
    {
        Text(text = "${person.age}", color = Color.Black,
            fontSize = MaterialTheme.typography.h4.fontSize ,
            fontWeight = FontWeight.Bold
            )
        Text(text = person.firstName, color = Color.Black,
            fontSize = MaterialTheme.typography.h5.fontSize ,
            fontWeight = FontWeight.Normal
        )
        Text(text = person.lastName, color = Color.Black,
            fontSize = MaterialTheme.typography.h5.fontSize ,
            fontWeight = FontWeight.Normal
        )
    }
}
@Preview
@Composable
fun CustomItemPreview(){
    CustomItem(person = Person(1, "iamstupid" , "Yes",12))
}