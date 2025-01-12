package ies.sequeros.tienda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Tienda(modifier: Modifier = Modifier) {
    Column(modifier=modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.error)) {
        Text(text = "Tienda")
    }
}