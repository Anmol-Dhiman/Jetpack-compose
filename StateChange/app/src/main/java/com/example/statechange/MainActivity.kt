package com.example.statechange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.statechange.ui.theme.StateChangeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeOtherBoxColor(modifier = Modifier.fillMaxSize())
        }
    }
}


//state change is same as the mvvm livedata  or mutableLivedata
//which means that if we change the state or we can say ui or attributes values
//then the ui will reset according to the values of state change
@Composable
fun ColorBox(modifier: Modifier = Modifier) {
//   remember is the lambda function which would not let the color values change when the composable is recomposed
    val color = remember {
        mutableStateOf(Color.Yellow)
    }

    Box(modifier = modifier
        .background(color.value)
        .clickable {
            color.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(), 1F
            )
        })
}


//this is how we can change the color of other boxes by clicking on the different box

@Composable
fun ChangeOtherBoxColor(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        val color = remember {
            mutableStateOf(Color.Yellow)
        }
        ColorChangedBox(modifier = Modifier
            .weight(1f)
            .fillMaxSize(), { color.value = it })
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color.value)
        )
    }

}

@Composable
fun ColorChangedBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(), 1F
                )
            )
        })
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorBox(Modifier.fillMaxSize())
}