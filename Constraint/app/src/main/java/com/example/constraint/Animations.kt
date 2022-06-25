package com.example.constraint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Animations : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressBar(percentage = 0.5f, number = 360)
            }
        }
    }
}

@Composable
fun AnimIntro() {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,
//                here we can animate

        tween(durationMillis = 3000, delayMillis = 300)
    )

    val colorState = remember {
        mutableStateOf(Color.Green)
    }

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(colorState.value),
        Alignment.Center
    ) {
        Button(onClick = {
            sizeState += 50.dp
        }) {
            Text(text = "increase size")
        }
    }
}


@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp, animDuration: Int = 2000,
    animDelay: Int = 0,

    ) {


//    when the animationPlayed state changes then it will run the ui part of composable
    var animationPlayed by remember {
        mutableStateOf(false)
    }

//    when the animationPlayed value changes to true then it will run this animation
    val currentPercentage =
        animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f, animationSpec = tween(
                durationMillis = animDuration, delayMillis = animDelay
            )
        )


    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    
//    this is the ui part for this composable
    Box(modifier = Modifier.size(radius * 2f), Alignment.Center) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}


