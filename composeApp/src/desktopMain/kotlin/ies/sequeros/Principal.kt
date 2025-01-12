package ies.sequeros

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Web

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Principal(navController:NavHostController, modifier: Modifier = Modifier) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
           // horizontalAlignment = Alignment.CenterHorizontally
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp).clickable {
                navController.navigate("tienda")
            }) {
            Icon(
                imageVector = Icons.Default.AddBusiness,
                contentDescription = "Entra a la tienda",
                tint = MaterialTheme.colorScheme.primary, // Cambia el color
                modifier = Modifier.size(96.dp)// Cambia el tamaño
            )
                Text("Tienda")
            }
            Column ( horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(20.dp).clickable {
                navController.navigate("administracion")
            }) {

            Icon(
                imageVector = Icons.Default.Web,
                contentDescription = "Entrar a administrar",
                tint = MaterialTheme.colorScheme.primary, // Cambia el color
                modifier = Modifier.size(96.dp) // Cambia el tamaño
            )
                Text("Administración")
            }
        }
    }

}