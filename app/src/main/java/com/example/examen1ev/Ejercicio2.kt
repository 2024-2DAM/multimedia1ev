package com.example.examen1ev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examen1ev.ui.ui.theme.Examen1evTheme

class Ejercicio2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen1evTheme {
                Ejercicio2Contents()
            }
        }
    }
}

@Composable
fun Ejercicio2Contents() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val enabled by remember {
        derivedStateOf {
            username.isNotEmpty() && password.length > 6
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = username,
                // onValueChange = { newText -> username = newText },
                onValueChange = { username = it },
                placeholder = { Text(text = "Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    username = ""
                    password = ""
                },
                enabled = enabled,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ejercicio2ContentsPreview() {
    Examen1evTheme {
        Ejercicio2Contents()
    }
}