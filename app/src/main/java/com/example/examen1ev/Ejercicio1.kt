package com.example.examen1ev

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examen1ev.ui.ui.theme.Examen1evTheme

class Ejercicio1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen1evTheme {
                Ejercicio1Contents()
            }
        }
    }
}

@Composable
fun Ejercicio1Contents() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F)
                )
                Spacer(Modifier.width(16.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Surname") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(3F)
                )
            }
            Spacer(Modifier.height(16.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "NIF") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.End)) {
                Text(text = "Register")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun Ejercicio1ContentsPreview() {
    Examen1evTheme {
        Ejercicio1Contents()
    }
}