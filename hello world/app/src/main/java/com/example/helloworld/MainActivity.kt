package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.temp)
            val title = "hey there i'm sherlock"
            val description = "hey there i'm sherlock"
            ImageCard(painter = painter, title = title, description = description)
        }
    }
}


//the convention for name of composable is Uppercase words
@Composable
fun ImageCard(painter: Painter, title: String, description: String, modifier: Modifier = Modifier) {
//here we pass the modifier to give the different properties to different ImageCard items


    Card(
        modifier = modifier
            .fillMaxSize(0.5f)
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp

    ) {

        //        this will set the composable on top of each other in a stack format
//   here fillMaxSize() will use the width and height size of parent as it's own size
        Box(modifier = Modifier.fillMaxSize()) {
            // which composable we put first will be at the bottom of the stack
            Image(
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
            )

//            this box is for creating the vertical gradient to show the text
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ), startY = 300f
                        )
                    )
            )



            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.BottomStart
            ) {
                Text(text = "$title", style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}


@Composable
fun Greeting(name: String) {

//    here the modifier is used to give the properties like width , height, background , resources etc

//   in the modifier the function executes sequentially so we can call the same function again and again
    Column(
        modifier = Modifier
            .background(Color.Blue)
            .width(400.dp)

            .padding(top = 16.dp, bottom = 16.dp)
            .border(2.dp, Color.Black)
            .height(400.dp),


//when we arrange the composable in column then we have to arrange then vertically and align horizontally
//        and in case of row vice versa

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround

    ) {

//        here the views are called composable
        Text(text = "Hello $name!", modifier = Modifier.clickable { })
        Text(text = "Hello $name!")
        Text(text = "Hello $name!")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val painter = painterResource(id = R.drawable.temp)
    val title = "hey there i'm sherlock"
    val description = "hey there i'm sherlock"
    ImageCard(painter = painter, title = title, description = description)

}