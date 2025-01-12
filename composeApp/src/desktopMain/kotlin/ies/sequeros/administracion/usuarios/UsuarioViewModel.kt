package ies.sequeros.administracion.usuarios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import ies.java.model.Usuario
import ies.java.repositorio.UsuarioRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate
import java.util.*

class UsuarioViewModel(val repository: ies.java.repositorio.UsuarioRepositorio): ViewModel() {
     var _usuarios = MutableStateFlow<MutableList<Usuario>>(mutableListOf())
    var _selected= MutableStateFlow<Usuario?>(null)
    init {
        _usuarios.value = _usuarios.value.apply {
            addAll(repository.usuarios)
        }
    }
    var usuarios: StateFlow<MutableList<Usuario>> = _usuarios
    var selected:MutableStateFlow<Usuario?> = _selected
    fun setSelected(item:Usuario){
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
        val original = this.getUsuario(usuario.email)
        if(original.isPresent) {
            repository.updateUsuario(usuario)
            _usuarios.value = _usuarios.value.toMutableList().apply {
                set(_usuarios.value.indexOf(original.get()), usuario)
            }

        }

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