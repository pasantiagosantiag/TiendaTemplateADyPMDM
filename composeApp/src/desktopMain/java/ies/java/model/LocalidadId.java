package ies.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LocalidadId implements Serializable {
    private static final long serialVersionUID = 8216712504036605905L;
    @Column(name = "codm", nullable = false, length = 4)
    private String codm;

    @Column(name = "provincia", nullable = false, length = 2)
    private String provincia;

    public String getCodm() {
        return codm;
    }

    public void setCodm(String codm) {
        this.codm = codm;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LocalidadId entity = (LocalidadId) o;
        return Objects.equals(this.codm, entity.codm) &&
                Objects.equals(this.provincia, entity.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codm, provincia);
    }

}