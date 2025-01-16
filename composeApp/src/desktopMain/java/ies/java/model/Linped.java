package ies.java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "linped")
public class Linped {
    @EmbeddedId
    private LinpedId id;

    @MapsId("numPedido")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "numPedido", nullable = false)
    private Pedido numPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "articulo", nullable = false)
    private Articulo articulo;

    @Column(name = "importe", nullable = false, precision = 9, scale = 2)
    private BigDecimal importe;

    @Column(name = "cantidad")
    private Integer cantidad;

    public LinpedId getId() {
        return id;
    }

    public void setId(LinpedId id) {
        this.id = id;
    }

    public Pedido getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Pedido numPedido) {
        this.numPedido = numPedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}