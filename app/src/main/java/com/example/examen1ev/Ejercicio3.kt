package com.example.examen1ev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examen1ev.model.Product
import com.example.examen1ev.ui.ui.theme.Examen1evTheme

class Ejercicio3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen1evTheme {
                Ejercicio3Contents(
                    listOf(
                        Product(1, "Tornillo", 10.0, "Tornillo de 5cm"),
                        Product(2, "Tuerca", 20.0, "Tamaño pequeño"),
                        Product(3, "Destornillador estrella", 30.0, "Herramienta manual"),
                        Product(4, "Martillo", 50.0, "Martillo de plástico"),
                        Product(5, "Desatascador", 20.0, "Tamaño grande"),
                        Product(6, "Destornillador plano", 30.0, "Herramienta manual")
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ejercicio3Contents(products: List<Product>) {
    Scaffold(
        modifier =
        Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = "Lista de productos") })
        },
        content = { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(products) { product ->
                    ProductCard(product = product)
                }
            }
        }
    )
}

@Composable
fun ProductCard(product: Product) {
    var isSelected by remember { mutableStateOf(false) }
    Card(
        onClick = { isSelected = !isSelected },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
    ) {
        Column(
            Modifier
                .padding(10.dp)
        ) {
            Row {
                Icon(
                    imageVector = if (isSelected) Icons.Default.Remove else Icons.Default.Add,
                    contentDescription = "Exandir",
                    modifier = Modifier.clickable {
                        isSelected = !isSelected
                    }
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = product.name,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
            if (isSelected) {
                Row(
                    modifier = Modifier.offset(20.dp)
                ) {
                    Text(text = "Id: ${product.id}")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Precio: ${product.price}")
                }
                Text(
                    modifier = Modifier.offset(20.dp),
                    text = "Descripcion: ${product.description}"
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Ejercicio3ContentsPreview() {
    Examen1evTheme {
        Ejercicio3Contents(
            listOf(
                Product(1, "Tornillo", 10.0, "Tornillo de 5cm"),
                Product(2, "Tuerca", 20.0, "Tamaño pequeño"),
                Product(3, "Destornillador estrella", 30.0, "Herramienta manual"),
                Product(4, "Martillo", 50.0, "Martillo de plástico"),
                Product(5, "Desatascador", 20.0, "Tamaño grande"),
                Product(6, "Destornillador plano", 30.0, "Herramienta manual")
            )
        )
    }
}