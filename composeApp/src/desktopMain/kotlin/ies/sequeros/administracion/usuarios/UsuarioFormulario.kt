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
    var email by remember { mutableStateOf(viewModel.selected.value?.email ?: "") }
    var nombre by remember { mutableStateOf(viewModel.selected.value?.nombre ?: "") }
    var apellidos by remember { mutableStateOf(viewModel.selected.value?.apellidos ?: "") }
    var dni by remember { mutableStateOf(viewModel.selected.value?.dni ?: "") }
    var telefono by remember { mutableStateOf(viewModel.selected.value?.telefono ?: "") }
    var calle by remember { mutableStateOf(viewModel.selected.value?.calle ?: "") }
    var calle2 by remember { mutableStateOf(viewModel.selected.value?.calle2 ?: "") }
    var codpos by remember { mutableStateOf(viewModel.selected.value?.codpos ?: "") }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Campo de correo electrónico
        OutlinedTextField(
            value = email,
            onValueChange = {
                email= it;
            },
            enabled = viewModel.selected.value == null,
            label = { Text("Correo electrónico") },
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de nombre
        OutlinedTextField(
            value = nombre,
            onValueChange = {

                nombre = it;


            },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de apellidos
        OutlinedTextField(
            value = apellidos,
            onValueChange = {

                apellidos = it;


            },
            label = { Text("Apellidos") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de DNI
        OutlinedTextField(
            value = dni,
            onValueChange = {

                dni = it;

            },
            label = { Text("DNI") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de teléfono
        OutlinedTextField(
            value = telefono,
            onValueChange = {

                telefono = it;

            },
            label = { Text("Teléfono") },
            // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de calle
        OutlinedTextField(
            value = calle,
            onValueChange = {

                calle = it;

            },
            label = { Text("Calle") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de calle 2
        OutlinedTextField(
            value = calle2,
            onValueChange = {

               calle2 = it;

            },
            label = { Text("Calle 2 (opcional)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de código postal
        OutlinedTextField(
            value = codpos,
            onValueChange = {

                codpos = it;

            },
            label = { Text("Código postal") },
            //  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Botón de envío
        Button(
            onClick = {
                var u:Usuario?
                if(viewModel.selected.value==null  ||viewModel.selected.value?.email?.isEmpty() ?:false) {
                    u = Usuario()
                    u.email = email
                }else{
                    u= viewModel.selected.value
                }
                    u?.nombre= nombre
                    u?.apellidos  = apellidos
                    u?.dni  = dni
                    u?.telefono = telefono
                    u?.calle = calle
                    u?.codpos = codpos
                    u?.calle2=calle2
                if (u != null) {
                    viewModel.agregarUsuario(u)
                }

                navController.popBackStack()
            },
            //enabled =  validarUsuario(usuario),
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
/*fun validarUsuario(usuario: Usuario):Boolean{
    val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    if(usuario.nombre.isEmpty() || usuario.email.isEmpty() || !usuario.email.matches(regex) ) {
       return  false
    }
     return true
}*/