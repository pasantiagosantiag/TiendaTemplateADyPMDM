package ies.java.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

 public class Usuario implements Cloneable, Comparable<Usuario>{

    private String email;
    private String nombre;
    private String apellidos;
    private String dni;
    private String telefono;
    private String calle;
    private String calle2;
    private String codpos;
    private LocalDate nacido;

    public Usuario(){
        this.email = "";
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
        this.telefono = "";
        this.calle = "";
        this.calle2 = "";
        this.codpos = "";
        this.nacido =LocalDate.of(1,1,1);
    }
    public Usuario(String email, String nombre, String apellidos, String dni, String telefono,
                   String calle, String calle2, String codpos, LocalDate nacido) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.calle = calle;
        this.calle2 = calle2;
        this.codpos = codpos;
        this.nacido = nacido;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getCodpos() {
        return codpos;
    }

    public void setCodpos(String codpos) {
        this.codpos = codpos;
    }

    public LocalDate getNacido() {
        return nacido;
    }

    public void setNacido(LocalDate nacido) {
        this.nacido = nacido;
    }

    @Override
    public Usuario clone() {

            Usuario tempo= new Usuario();
            tempo.email = new String(this.email);
            tempo.nombre = new String(this.nombre);
            tempo.apellidos = new String(this.apellidos);
            tempo.dni = new String(this.dni);
            tempo.telefono = new String(this.telefono);
            tempo.calle = new String(this.calle);
            tempo.calle2 = new String(this.calle2);
            tempo.codpos = new String(this.codpos);
            tempo.nacido = LocalDate.of(this.nacido.getYear(), this.nacido.getMonth(),this.nacido.getDayOfMonth());
            return tempo; // Copia superficial

    }
    public void copy(Usuario u){
        this.email = new String(u.email);
        this.nombre = new String(u.nombre);
        this.apellidos = new String(u.apellidos);
        this.dni = new String(u.dni);
        this.telefono = new String(u.telefono);
        this.calle = new String(u.calle);
        this.calle2 = new String(u.calle2);
        this.codpos = new String(u.codpos);
        this.nacido = LocalDate.of(u.nacido.getYear(), u.nacido.getMonth(),u.nacido.getDayOfMonth());

    }

    @Override
    public int compareTo(@NotNull Usuario o) {
        return o.email.compareTo(this.email);
    }

    public boolean equals(@NotNull Usuario u){
        return this.email.equals(u.email);
    }
    public int hashCode(){
        return this.email.hashCode();
    }
}