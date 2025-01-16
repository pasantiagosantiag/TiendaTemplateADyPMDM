package ies.java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "direnvio")
public class Direnvio {
    @Id
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email", nullable = false)
    private Usuario usuario;

    @Column(name = "calle", length = 45)
    private String calle;

    @Column(name = "calle2", length = 45)
    private String calle2;

    @Column(name = "codpos", length = 5)
    private String codpos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Localidad localidad;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

}