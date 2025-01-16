package ies.java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tv")
public class Tv {
    @Id
    @Column(name = "cod", nullable = false, length = 7)
    private String cod;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod", nullable = false)
    private Articulo articulo;

    @Column(name = "panel", length = 45)
    private String panel;

    @Column(name = "pantalla")
    private Short pantalla;

    @Column(name = "resolucion", length = 15)
    private String resolucion;

    @Column(name = "hdreadyfullhd", length = 6)
    private String hdreadyfullhd;

    @Column(name = "tdt")
    private Boolean tdt;

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

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public Short getPantalla() {
        return pantalla;
    }

    public void setPantalla(Short pantalla) {
        this.pantalla = pantalla;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getHdreadyfullhd() {
        return hdreadyfullhd;
    }

    public void setHdreadyfullhd(String hdreadyfullhd) {
        this.hdreadyfullhd = hdreadyfullhd;
    }

    public Boolean getTdt() {
        return tdt;
    }

    public void setTdt(Boolean tdt) {
        this.tdt = tdt;
    }

}