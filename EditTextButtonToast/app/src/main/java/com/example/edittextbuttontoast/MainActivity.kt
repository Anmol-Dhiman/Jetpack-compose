package com.example.edittextbuttontoast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListLazyColumn()
        }
    }
}


@Composable
fun ScrollableListLazyColumn(modifier: Modifier = Modifier) {

//    this will load the text only when it need to be shown in the device
//    but if we use simple column and for loop then it will generate the whole text field and
//    which is not efficient for the memory
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(1000) {
            Text(
                text = "item $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,

                )
        }
    }
}


@Composable
fun DifferentInputsInLazyColumn(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(
            listOf(
                "Ronak",
                "Shekhu",
                "Vaibhav",
                "Rajat",
                "Nishant",
                "Quatri"
            )
        ) { index, string ->
            Text(
                text = "$string $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun Ui(modifier: Modifier = Modifier) {

    val scaffoldState = rememberScaffoldState()
    var text by remember { mutableStateOf(value = "") }
    val scope = rememberCoroutineScope()

//    scaffold is used to set the snackBar as the snackBar show on the parentTop and to get control over the positioning we use scaffold
    Scaffold(modifier = modifier.fillMaxSize(), scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = text,
                label = {
                    Text(text = "Enter your name")
                },
                onValueChange = { text = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(message = "Hello $text")
                }
            }) {
                Text(text = "Greet me")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScrollableListLazyColumn()
}