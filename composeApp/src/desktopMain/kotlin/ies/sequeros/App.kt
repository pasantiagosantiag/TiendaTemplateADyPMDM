package ies.sequeros

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import ies.sequeros.administracion.Administracion
import ies.sequeros.tienda.Tienda

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme() {


        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "principal" // Pantalla inicial
        ) {
            composable("principal") {
                Principal(navController)
            }
            composable("tienda") {
                Tienda()//navController)
            }
            composable("administracion") {
               Administracion() //(navController)
            }
        }

    }
}