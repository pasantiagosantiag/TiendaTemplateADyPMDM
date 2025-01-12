package ies.sequeros.administracion.usuarios

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ies.java.model.Usuario

@Composable
fun UsuarioFormulario(viewModel: UsuarioViewModel, navController: NavHostController, expandido:Boolean, atras: ()->Unit) {
    // Estados para los campos
    var email by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var calle by remember { mutableStateOf("") }
    var calle2 by remember { mutableStateOf("") }
    var codpos by remember { mutableStateOf("") }
    //se hace una copia
    var usuario by remember {
        mutableStateOf<Usuario>(
            (if (viewModel.selected.value != null) {
                viewModel.selected.value!!.clone()
            } else {
                Usuario()
            })
        )
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Campo de correo electrónico
        OutlinedTextField(
            value = usuario.email,
            onValueChange = {
                var t = usuario.clone()
                t.email = it;
                usuario = t;
            },
            enabled = viewModel.selected.value == null,
            label = { Text("Correo electrónico") },
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de nombre
        OutlinedTextField(
            value = usuario.nombre,
            onValueChange = {
                var t = usuario.clone()
                t.nombre = it;
                usuario = t;

            },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de apellidos
        OutlinedTextField(
            value = usuario.apellidos,
            onValueChange = {
                var t = usuario.clone()
                t.apellidos = it;
                usuario = t;

            },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de DNI
        OutlinedTextField(
            value = usuario.dni,
            onValueChange = {
                var t = usuario.clone()
                t.dni = it;
                usuario = t;
            },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de teléfono
        OutlinedTextField(
            value = usuario.telefono,
            onValueChange = {
                var t = usuario.clone()
                t.telefono = it;
                usuario = t;
            },
            label = { Text("Teléfono") },
            // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de calle
        OutlinedTextField(
            value = usuario.calle,
            onValueChange = {
                var t = usuario.clone()
                t.calle = it;
                usuario = t;
            },
            label = { Text("Calle") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de calle 2
        OutlinedTextField(
            value = usuario.calle2,
            onValueChange = {
                var t = usuario.clone()
                t.calle2 = it;
                usuario = t;
            },
            label = { Text("Calle 2 (opcional)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de código postal
        OutlinedTextField(
            value = usuario.codpos,
            onValueChange = {
                var t = usuario.clone()
                t.codpos = it;
                usuario = t;
            },
            label = { Text("Código postal") },
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Botón de envío
        Button(
            onClick = {
                if(viewModel.selected.value==null || viewModel.selected.value?.email?.isEmpty() ?:false ){
                    viewModel.agregarUsuario(usuario)
                }else{
                    viewModel.updateUsuario(usuario)
                }
                navController.popBackStack()
            },
            enabled =  validarUsuario(usuario),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
        if(!expandido){
            Button(
                onClick = {
                   atras()
                },

                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}

/**
 * Ejemplo de validación
 */
fun validarUsuario(usuario: Usuario):Boolean{
    val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    if(usuario.nombre.isEmpty() || usuario.email.isEmpty() || !usuario.email.matches(regex) ) {
       return  false
    }
     return true
}