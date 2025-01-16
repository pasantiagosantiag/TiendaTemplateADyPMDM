package ies.java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "articulo", nullable = false, length = 7)
    private String articulo;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "articulo", nullable = false)
    private Articulo articulo1;

    @Column(name = "disponible")
    private Integer disponible;

    @Lob
    @Column(name = "entrega")
    private String entrega;

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Articulo getArticulo1() {
        return articulo1;
    }

    public void setArticulo1(Articulo articulo1) {
        this.articulo1 = articulo1;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

}