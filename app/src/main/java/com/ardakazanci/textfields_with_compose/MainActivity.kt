package com.ardakazanci.textfields_with_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.ardakazanci.textfields_with_compose.ui.theme.TextFieldsWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldsWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /**
         * readOnly = true,
         * enabled = false
         * singleLine = true
         * maxLine = Int value
         * keyboardActions - ime button clicked handler
         */

        var text by remember {
            mutableStateOf("Type Here...")
        }
        // Outlined - BasicTextField 
        TextField(value = text, onValueChange = {
            text = it
        }, label = {
            Text(text = "Label")
        }, leadingIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
            }
        }, trailingIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "Email Icon")
            }
        }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFieldsWithComposeTheme {
        Greeting("Android")
    }
}