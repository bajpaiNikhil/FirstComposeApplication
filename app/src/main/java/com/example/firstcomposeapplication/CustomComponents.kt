package com.example.firstcomposeapplication


import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit


@Composable
fun CustomComponents(
    canvasSize : Dp = 300.dp,
    indicatorValue : Int = 0,
    maxIndicatorValue : Int = 100,
    backGroundIndicatorColor: Color =  MaterialTheme.colors.onSurface.copy(alpha = .2f),
    backGroundIndicatorStrokeWidth : Float = 100f,
    foreGroundIndicatorColor: Color = MaterialTheme.colors.primary ,
    foreGroundIndicatorStrokeWidth : Float = 100f ,
    bigTextFontSize : TextUnit = MaterialTheme.typography.h3.fontSize  ,
    bigTextColor :Color = MaterialTheme.colors.onSurface,
    bigTextSuffix :String = "GB",
    smallText :String = "Remaining" ,
    smallTextColor :Color = MaterialTheme.colors.onSurface.copy(alpha = .3f)  ,
    smallTextFontSize : TextUnit = MaterialTheme.typography.subtitle1.fontSize
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

    val receivedValue by animateIntAsState(
        targetValue = allowedIndicatorValue ,
    animationSpec = tween(1000))

    val animatedBigTextColor  by animateColorAsState(
        targetValue = if(allowedIndicatorValue == 0)
            MaterialTheme.colors.onSurface.copy(alpha = .3f)
    else
        bigTextColor ,
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
        , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        EmbeddedElements(
            bigText = receivedValue ,
            bigTextFontSize =bigTextFontSize ,
            bigTextColor = animatedBigTextColor,
            bigTextSuffix = bigTextSuffix,
            smallText = smallText,
            smallTextColor = smallTextColor ,
            smallTextFontSize = smallTextFontSize
        )
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
fun EmbeddedElements(
    bigText: Int ,
    bigTextFontSize : TextUnit ,
    bigTextColor : Color,
    bigTextSuffix: String ,
    smallText : String ,
    smallTextColor: Color , 
    smallTextFontSize : TextUnit
    
){

    Text(
        text = smallText ,
    color = smallTextColor ,
    fontSize =  smallTextFontSize ,
    textAlign = TextAlign.Center
    )
    Text(
        text = "$bigText  ${bigTextSuffix.take(2)} " ,
        color = bigTextColor ,
        fontSize =  bigTextFontSize ,
        textAlign = TextAlign.Center ,
        fontWeight = FontWeight.ExtraBold
    )
}

@Preview(showBackground = true)
@Composable
fun CustomComponentPreview(){
    CustomComponents()
}