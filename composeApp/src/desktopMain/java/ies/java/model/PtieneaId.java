package ies.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PtieneaId implements Serializable {
    private static final long serialVersionUID = -658937385342036443L;
    @Column(name = "pack", nullable = false, length = 7)
    private String pack;

    @Column(name = "articulo", nullable = false, length = 7)
    private String articulo;

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PtieneaId entity = (PtieneaId) o;
        return Objects.equals(this.articulo, entity.articulo) &&
                Objects.equals(this.pack, entity.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articulo, pack);
    }

}