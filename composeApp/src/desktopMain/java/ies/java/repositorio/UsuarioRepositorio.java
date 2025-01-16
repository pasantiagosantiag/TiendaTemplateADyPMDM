package ies.java.repositorio;

import ies.java.SingletonFactory;
import ies.java.model.Usuario;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.*;

//import kotlinx.serialization.
public class UsuarioRepositorio {
    Session session;
    public UsuarioRepositorio(){

        session = SingletonFactory.getConnection().getSession();

    }

    public void agregarUsuario(Usuario usuario) {
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();

       // this.usuarios.add(usuario);
    }
    public void eliminarUsuario(Usuario usuario) {
        session.beginTransaction();
        session.delete(usuario);
        session.getTransaction().commit();
    }

   /* public void setUsuarios(ArrayList<Usuario> usuarios) {
        //this.usuarios = usuarios;
    }*/
    public List<Usuario> getUsuarios() {
        var session=SingletonFactory.getConnection().getSession();

        var items=session.createQuery("SELECT u FROM Usuario u JOIN FETCH u.localidad ", Usuario.class).getResultList();
        return items;
    }

    /**
     * Devuelve una copia de solo lectura
     * @param email
     * @return
     */
    public Optional<Usuario> getUsuario(String email) {

        var usuario = session.createQuery("select u from Usuario u where u.email like ?1").setParameter(1,email).getResultList().stream().findFirst();
        if (usuario.isPresent()) {
            return usuario; //Optional.of(usuario.get().clone());
        }else
            return Optional.empty();

    }
    public boolean existeUsuario(String email) {
        var usuario = getUsuario(email);
        if (usuario.isPresent()) {
            return true; //Optional.of(usuario.get().clone());
        }else
            return false;
    }
    public void removerUsuario(String email) {
        session.beginTransaction();
        session.delete(getUsuario(email));
        session.getTransaction().commit();

    }

    public void updateUsuario(Usuario usuario) {
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();



    }
}
