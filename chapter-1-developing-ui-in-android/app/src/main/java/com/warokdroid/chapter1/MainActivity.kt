package com.warokdroid.chapter1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.warokdroid.chapter1.ui.theme.Chapter1developinguiinandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter1developinguiinandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Erik")
                        TextButton(text = "Click Me the Text Button")
                        ImageButton()
                        TextImageButton(text = "Click Me!")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}

@Composable
fun TextButton(text: String) {
    Box(modifier = Modifier.clickable {}) {
        Text(text = text)
    }
}

@Composable
fun ImageButton() {
    Box(modifier = Modifier.clickable { }) {
        Icon(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
    }
}

@Composable
fun TextImageButton(text: String) {
    Box(modifier = Modifier.clickable { }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chapter1developinguiinandroidTheme {
        Greeting("Erik")
    }
}