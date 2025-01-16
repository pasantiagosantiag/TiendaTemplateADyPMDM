package ies.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CestaId implements Serializable {
    private static final long serialVersionUID = -7826623052944399041L;
    @Column(name = "articulo", nullable = false, length = 7)
    private String articulo;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CestaId entity = (CestaId) o;
        return Objects.equals(this.usuario, entity.usuario) &&
                Objects.equals(this.articulo, entity.articulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, articulo);
    }

}