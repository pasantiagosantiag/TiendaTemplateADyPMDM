package ies.sequeros.administracion.usuarios

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource
import tiendatemplate.composeapp.generated.resources.Res
import tiendatemplate.composeapp.generated.resources.man
import tiendatemplate.composeapp.generated.resources.woman

@Composable
fun UsuarioDetalle(usuarioViewModel: UsuarioViewModel, navController: NavController, expandido:Boolean, atras: ()->Unit) {

   val selected=usuarioViewModel.selected.collectAsState()

        Column(
            modifier =
            Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment =
            Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            selected.value?.let {
                Image(
                    painterResource(
                        if (Math.random() > 0.5)
                            Res.drawable.woman
                        else
                            Res.drawable.man
                    ), it.nombre,
                    modifier =
                    Modifier.weight(8f).weight(3f)
                )
            }
            Text(
                text = selected.value?.let { "Nombre: ${it.nombre}, ${it.apellidos} Correo: ${it.email
                }" }?:"No seleccionado",
                modifier = Modifier.padding(16.dp).weight(1f)
            )
            if(!expandido){
                Button(
                    onClick = {
                        atras()
                    },

                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.material.Text("Volver")
                }
            }
        }
}