package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Sherlock")
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
        Text(text = "Hello $name!", modifier = Modifier.clickable {       })
        Text(text = "Hello $name!")
        Text(text = "Hello $name!")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting("Android")

}