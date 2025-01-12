package ies.sequeros.administracion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.*


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import ies.java.repositorio.UsuarioRepositorio
import ies.sequeros.administracion.graficos.EjemploGrafico
import ies.sequeros.administracion.usuarios.UsuarioViewModel
import ies.sequeros.administracion.usuarios.UsuariosListado

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    HOME("Home",  Icons.Default.Home, "Home"),
    MARCAS("Marcas", Icons.Filled.Category,"Gestión de marcas"),
    PRODUCTOS("Productos", Icons.Filled.Tv,"Gestión de productos"),
    LISTADOS("Listados", Icons.Filled.ListAlt,"Listado "),
    GRAFICOS("Estadísticas", Icons.Filled.BarChart,"Estadísticas"),
    USUARIOS("Usuarios(no se pide)", Icons.Filled.People,"Usuarios")



}
@Composable
fun Administracion(modifier: Modifier = Modifier) {
    var seleted = remember { mutableStateOf(AppDestinations.HOME)}
    val usuarioViewModel:UsuarioViewModel= viewModel(
        factory = UsuarioViewModel.Factory,
        extras = MutableCreationExtras().apply {
            set(UsuarioViewModel.USUARIO_REPOSITORIO_KEY,
                UsuarioRepositorio())
        },
    )
    Column(modifier=modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.error)) {
        NavigationSuiteScaffold(
            modifier=Modifier.background(MaterialTheme.colorScheme.error),
            navigationSuiteItems = {

               AppDestinations.entries.forEach {
                    item(
                        icon = {
                            androidx.compose.material3.Icon(
                                imageVector = it.icon,
                                contentDescription = it.contentDescription,
                               // tint = MaterialTheme.colorScheme.inversePrimary, // Cambia el color
                                //modifier = Modifier.size(96.dp)// Cambia el tamaño
                            )
                        },
                        label ={ Text(it.label) },

                        selected = seleted.value== it,
                        onClick = {
                            seleted.value=it
                        }
                    )
                }
            }
        ) {
            when(seleted.value){
                AppDestinations.HOME-> PrincipalAdministracion()
                AppDestinations.MARCAS -> PrincipalAdministracion()
                AppDestinations.PRODUCTOS -> PrincipalAdministracion()
                AppDestinations.LISTADOS -> PrincipalAdministracion()
                AppDestinations.GRAFICOS -> EjemploGrafico(usuarioViewModel)
                AppDestinations.USUARIOS -> UsuariosListado(usuarioViewModel)
            }

        }
    }
}