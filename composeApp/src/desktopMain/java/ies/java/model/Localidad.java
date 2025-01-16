package ies.java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "localidad")
public class Localidad {
    @EmbeddedId
    private LocalidadId id;

    @MapsId("provincia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "provincia", nullable = false)
    private Provincia provincia;

    @Column(name = "pueblo", nullable = false, length = 50)
    private String pueblo;

    public LocalidadId getId() {
        return id;
    }

    public void setId(LocalidadId id) {
        this.id = id;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

}