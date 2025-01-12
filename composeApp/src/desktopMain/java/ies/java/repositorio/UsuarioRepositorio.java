package ies.java.repositorio;

import ies.java.model.Usuario;

import java.time.LocalDate;
import java.util.*;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.KSerializer;
//import kotlinx.serialization.
public class UsuarioRepositorio {
    private ArrayList<Usuario> usuarios;
    public UsuarioRepositorio() {
        this.usuarios = new ArrayList<>();
        // Llenar el arreglo con instancias de Usuario
        this.usuarios.add( new Usuario("alice@mail.com", "Alice", "Doe", "12345678A", "555-1234",
                "Calle Falsa", "Apt. 101", "28001", LocalDate.of(1990, 5, 12)));
        this.usuarios.add( new Usuario("bob@mail.com", "Bob", "Smith", "87654321B", "555-5678",
                "Calle Real", "Apt. 102", "28002", LocalDate.of(1985, 8, 22)));
        this.usuarios.add(  new Usuario("carol@mail.com", "Carol", "Johnson", "11223344C", "555-9101",
                "Avenida de España", "Apt. 103", "28003", LocalDate.of(1995, 11, 30)));
        this.usuarios.add(  new Usuario("david@mail.com", "David", "Brown", "22334455D", "555-1122",
                "Calle Mayor", "Apt. 104", "28004", LocalDate.of(1988, 4, 15)));
        this.usuarios.add( new Usuario("eve@mail.com", "Eve", "Williams", "33445566E", "555-2233",
                "Calle Sol", "Apt. 105", "28005", LocalDate.of(1992, 12, 1)));
        this.usuarios.add( new Usuario("frank@mail.com", "Frank", "Jones", "44556677F", "555-3344",
                "Calle Luna", "Apt. 106", "28006", LocalDate.of(1987, 7, 18)));
        this.usuarios.add( new Usuario("grace@mail.com", "Grace", "Miller", "55667788G", "555-4455",
                "Calle Estrella", "Apt. 107", "28007", LocalDate.of(1991, 3, 25)));
        this.usuarios.add( new Usuario("hank@mail.com", "Hank", "Davis", "66778899H", "555-5566",
                "Calle del Sol", "Apt. 108", "28008", LocalDate.of(1994, 6, 30)));
        this.usuarios.add( new Usuario("irene@mail.com", "Irene", "Rodriguez", "77889900I", "555-6677",
                "Calle Mar", "Apt. 109", "28009", LocalDate.of(1996, 1, 8)));
        this.usuarios.add( new Usuario("jack@mail.com", "Jack", "Martinez", "88990011J", "555-7788","Calle Viento", "Apt. 110", "28010", LocalDate.of(1993, 9, 20)));



    }
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    public void eliminarUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    /**
     * Devuelve una copia de solo lectura
     * @param email
     * @return
     */
    public Optional<Usuario> getUsuario(String email) {
        var usuario = this.usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst();
        if (usuario.isPresent()) {
            return usuario; //Optional.of(usuario.get().clone());
        }else
            return Optional.empty();

    }
    public boolean existeUsuario(String email) {
        return this.usuarios.stream().filter(usuario1 -> usuario1.getEmail().equals(email)).findFirst().isPresent();
    }
    public void removerUsuario(String email) {
        this.usuarios.removeIf(usuario1 -> usuario1.getEmail().equals(email));
    }
    private int getIndexByMail(String mail){
        boolean encontrado = false;
        int contador=0;
        for(Usuario usuario : this.usuarios){
            if(usuario.getEmail().equals(mail)){
                encontrado = true;
                break;
            }
            else {
                contador++;
            }
        }
        if(encontrado){
            return contador;
        }
        else {
            return -1;
        }
    }
    public void updateUsuario(Usuario usuario) {
        var original=this.getUsuario(usuario.getEmail());
        if(original.isPresent()) {
            var index=this.getIndexByMail(original.get().getEmail());
            if(index != -1) {
            this.usuarios.set(index, usuario);
            }
        }

    }
}
