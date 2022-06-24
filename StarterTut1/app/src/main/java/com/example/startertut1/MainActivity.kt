package com.example.startertut1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            here in jetpack compose we work in row and column system and this is how we set the views

//            offset is the margin in jeptack
            Column( ) {
                Text(text = "Hello", modifier = Modifier.offset(10.dp, 10.dp))
                Text(text = "World!!")
            }
        }
    }
}



