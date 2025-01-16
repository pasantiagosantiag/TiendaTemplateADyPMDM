package ies.java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "objetivo")
public class Objetivo {
    @Id
    @Column(name = "cod", nullable = false, length = 7)
    private String cod;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod", nullable = false)
    private Articulo articulo;

    @Column(name = "tipo", length = 15)
    private String tipo;

    @Column(name = "montura", length = 15)
    private String montura;

    @Column(name = "focal", length = 10)
    private String focal;

    @Column(name = "apertura", length = 10)
    private String apertura;

    @Column(name = "especiales", length = 35)
    private String especiales;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMontura() {
        return montura;
    }

    public void setMontura(String montura) {
        this.montura = montura;
    }

    public String getFocal() {
        return focal;
    }

    public void setFocal(String focal) {
        this.focal = focal;
    }

    public String getApertura() {
        return apertura;
    }

    public void setApertura(String apertura) {
        this.apertura = apertura;
    }

    public String getEspeciales() {
        return especiales;
    }

    public void setEspeciales(String especiales) {
        this.especiales = especiales;
    }

}