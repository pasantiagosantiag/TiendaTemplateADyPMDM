package ies.sequeros.administracion.usuarios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import ies.java.model.Localidad
import ies.java.model.Usuario
import ies.java.repositorio.UsuarioRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class UsuarioViewModel(val repository: ies.java.repositorio.UsuarioRepositorio): ViewModel() {
     var _usuarios = MutableStateFlow<MutableList<Usuario>>(mutableListOf())
    var _selected= MutableStateFlow<Usuario?>(null)
    init {
        _usuarios.value = _usuarios.value.apply {
            addAll(repository.usuarios)
        }
    }
    val usuarios: StateFlow<MutableList<Usuario>> = _usuarios.asStateFlow()

    var selected:StateFlow<Usuario?> = _selected
    fun setSelected(item: Usuario){
        _selected.value = item
    }
    fun unselect(){
        _selected.value = null
    }
    fun agregarUsuario(usuario: Usuario) {
       repository.agregarUsuario(usuario)
        _usuarios.value = _usuarios.value.toMutableList().apply {
            add( usuario)
        }
    }

    fun guardarusuario(email:String,nombre:String,apellidos:String,dni:String,telefono:String, calle:String,calle2:String, codpos:String){
        if(selected.value==null){
            var u=Usuario()
            u.nombre=nombre
            u.email=email;
            u.apellidos=apellidos;
            u.dni=dni;
            u.telefono=telefono;
            u.calle=calle;
            u.codpos=codpos;
            u.calle2=calle2;
           // u.localidad

            repository.agregarUsuario(u)
        }
        else{
            selected.value?.let {
                it.nombre=nombre;
               repository.updateUsuario(it)
            }

        }
    }
    fun getUsuario(email: String): Optional<Usuario> {
        return repository.getUsuario(email)
    }
    fun existeUsuario(email: String): Boolean {
        return repository.existeUsuario(email)
    }
    fun removerUsuario(email: String) {
        repository.removerUsuario(email)
        _usuarios.value = _usuarios.value.toMutableList().apply {
            removeAll {
               email==it.email
            }

        }


    }

    fun updateUsuario(usuario: Usuario) {
        repository.updateUsuario(usuario)
        /* usuario.email?.let {
             var u= this.getUsuario(it)
        if(u.isPresent) {
            repository.updateUsuario(usuario)
            _usuarios.value = _usuarios.value.toMutableList().apply {
                set(_usuarios.value.indexOf(u.get()), usuario)
            }

        }
        }*/

    }
    companion object {
        val USUARIO_REPOSITORIO_KEY= object  : CreationExtras.Key<UsuarioRepositorio> {}

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repositorio = this[USUARIO_REPOSITORIO_KEY] as UsuarioRepositorio
                UsuarioViewModel(repositorio)
            }
        }
    }


}