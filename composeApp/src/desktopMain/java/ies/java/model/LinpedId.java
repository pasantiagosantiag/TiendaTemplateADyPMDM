package ies.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinpedId implements Serializable {
    private static final long serialVersionUID = -6815526767099823168L;
    @Column(name = "linea", nullable = false)
    private Integer linea;

    @Column(name = "numPedido", nullable = false)
    private Integer numPedido;

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinpedId entity = (LinpedId) o;
        return Objects.equals(this.numPedido, entity.numPedido) &&
                Objects.equals(this.linea, entity.linea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPedido, linea);
    }

}