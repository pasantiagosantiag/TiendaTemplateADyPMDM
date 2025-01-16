package ies.sequeros.administracion.usuarios

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.layout.PaneAdaptedValue
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ies.java.model.Usuario
@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun UsuariosListado(usuarioViewModel: UsuarioViewModel) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()
    val navController = rememberNavController()
    val isListAndDetailVisible =
        navigator.scaffoldValue[ListDetailPaneScaffoldRole.Detail] == PaneAdaptedValue.Expanded &&
                navigator.scaffoldValue[ListDetailPaneScaffoldRole.List] == PaneAdaptedValue.Expanded

    val items by usuarioViewModel.usuarios.collectAsState()
    var selected: Usuario? by rememberSaveable { mutableStateOf(null) }

    Column {

        ListDetailPaneScaffold(
            directive = navigator.scaffoldDirective,
            value = navigator.scaffoldValue,
            modifier = Modifier.padding(10.dp),
            listPane = {
                //para el scroll de la lista
                val scrollState = rememberScrollState()

                Column(modifier = Modifier.fillMaxSize().padding(8.dp).verticalScroll(scrollState)) {
                    Row ( verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Nuevo",
                            tint = MaterialTheme.colorScheme.primary, // Cambia el color
                            modifier = Modifier.clickable {
                                usuarioViewModel.unselect()
                                navController.navigate(route = "editar")
                            }// Cambia el tamaño

                        )
                        Text("Nuevo")
                    }
                    items.forEach { item ->
                        Row {
                            Text(
                                text = item.nombre + " " + item.apellidos+" "+item.pedidos.size.toString(),
                                modifier = Modifier
                                    .width(150.dp)
                                    .clickable {
                                        selected = item
                                        usuarioViewModel.setSelected(item)
                                        navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                                        navController.navigate("detalle")
                                    }
                                    .padding(16.dp)
                            )
                            Button(onClick = {
                                usuarioViewModel.setSelected(item)
                                navController.navigate("editar")

                            }) {
                                Text(text = "Editar" )
                            }


                            Button(onClick = {
                                item.email?.let { usuarioViewModel.removerUsuario(it) }

                                if (selected == item)
                                    selected = null
                            }) {
                                Text(text = "Borrar")
                            }

                        }
                    }
                }
            },
            detailPane = {
                NavHost(
                    navController = navController,
                    startDestination = "detalle" // Pantalla inicial
                ) {
                    composable("detalle") {
                        UsuarioDetalle(usuarioViewModel,navController, isListAndDetailVisible
                    ) {
                        if (navigator.canNavigateBack())
                            navigator.navigateBack()
                    }
                    }
                    composable("editar") { UsuarioFormulario(usuarioViewModel,navController, isListAndDetailVisible
                    ) {
                        if (navigator.canNavigateBack())
                            navigator.navigateBack()
                    }
                    }

                }
            })

    }
}

