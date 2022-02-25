package com.example.firstcomposeapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.theme.Shapes


@ExperimentalMaterialApi
@Composable

fun ExpandableCard(
    title : String ,
    titleFontSize : TextUnit = MaterialTheme.typography.h6.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold ,
    description:String ,
    descriptionFontSize :TextUnit = MaterialTheme.typography.subtitle1.fontSize ,
    descriptionFontWeight: FontWeight = FontWeight.Normal ,
    descriptionMaxLine : Int = 4 ,
    shape : CornerBasedShape = Shapes.medium  ,
    padding : Dp = 12.dp

){
    var expandedState by remember{ mutableStateOf(false)}
    val rotateArrow by animateFloatAsState(
        targetValue = if(expandedState) 180f else 0f
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ) ,
        shape = shape ,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(padding)) {
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                text =    title  ,
                fontWeight = titleFontWeight ,
                fontSize = titleFontSize ,
                    maxLines = 1 ,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(

                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotateArrow),
                    onClick = {
                        expandedState  = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown ,
                        contentDescription = "Drop-Down-Arrow" ,

                    )
                }
            }
            if (expandedState){

                Text(description . repeat(20) ,
                fontSize = descriptionFontSize ,
                fontWeight = descriptionFontWeight ,
                maxLines = descriptionMaxLine ,
                overflow = TextOverflow.Ellipsis )
            }

        }
    }

}
@ExperimentalMaterialApi
@Composable
@Preview
fun ExpandableCardPreview(){
    ExpandableCard(title = "Iamstupid" , description = "weAreStupid")
}