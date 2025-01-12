package ies.sequeros.administracion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBusiness
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PrincipalAdministracion() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            // horizontalAlignment = Alignment.CenterHorizontally
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            ) {
            Icon(
                imageVector = Icons.Default.Apps,
                contentDescription = "Logo",
                tint = MaterialTheme.colorScheme.primary, // Cambia el color
                modifier = Modifier.size(96.dp)// Cambia el tamaño
            )
                Text("Administración de la tienda SEQUEROS DAM", Modifier.padding(16.dp).align(Alignment.CenterVertically),
                    fontSize = 20.sp)

        }
    }
}