package com.example.firstcomposeapplication


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*
import androidx.compose.runtime.*


@Composable
fun CustomComponents(
    canvasSize : Dp = 300.dp,
    indicatorValue : Int = 0,
    maxIndicatorValue : Int = 100,
    backGroundIndicatorColor: Color =  MaterialTheme.colors.onSurface.copy(alpha = .2f),
    backGroundIndicatorStrokeWidth : Float = 100f,
    foreGroundIndicatorColor: Color = MaterialTheme.colors.primary ,
    foreGroundIndicatorStrokeWidth : Float = 100f ,
){
    var allowedIndicatorValue  by remember { mutableStateOf(maxIndicatorValue)}

    allowedIndicatorValue =  if (indicatorValue <= maxIndicatorValue){
        indicatorValue
    }else{
        maxIndicatorValue
    }

    var animatedIndicatorValue by remember { mutableStateOf( 0f) }
    LaunchedEffect(key1 = allowedIndicatorValue){
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }

    val percentage = (animatedIndicatorValue /  maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat() ,
        animationSpec = tween(1000)
        )

    Column(modifier = Modifier
        .size(canvasSize)
        .drawBehind {
            val componentSize = size / 1.25f
            backgroundIndicator(
                componentSize = componentSize,
                indicatorColor = backGroundIndicatorColor,
                indicatorStrokeWidth = backGroundIndicatorStrokeWidth,
            )
            foreGroundIndicator(
                sweepAngle = sweepAngle,
                componentSize = componentSize,
                indicatorColor = foreGroundIndicatorColor,
                indicatorStrokeWidth = foreGroundIndicatorStrokeWidth,
            )
        }
    )
    {

    }
}

fun DrawScope.backgroundIndicator(
    componentSize : Size,
    indicatorColor : Color,
    indicatorStrokeWidth: Float
){

    drawArc(
        size = componentSize,
        color = indicatorColor ,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth ,
            cap = StrokeCap.Round
        ) ,
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y= (size.height - componentSize.height)/2f
        )
    )

}
fun DrawScope.foreGroundIndicator(
    sweepAngle : Float ,
    componentSize : Size,
    indicatorColor : Color,
    indicatorStrokeWidth: Float
){

    drawArc(
        size = componentSize,
        color = indicatorColor ,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth ,
            cap = StrokeCap.Round
        ) ,
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y= (size.height - componentSize.height)/2f
        )
    )

}


@Composable
fun EmbeddedElements(){

}

@Preview(showBackground = true)
@Composable
fun CustomComponentPreview(){
    CustomComponents()
}