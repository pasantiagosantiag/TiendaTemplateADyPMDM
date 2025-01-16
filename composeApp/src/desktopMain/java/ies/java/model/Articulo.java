package ies.java.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "articulo")
public class Articulo {
    @Id
    @Column(name = "cod", nullable = false, length = 7)
    private String cod;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "pvp", precision = 7, scale = 2)
    private BigDecimal pvp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca")
    private Marca marca;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "urlimagen", length = 100)
    private String urlimagen;

    @Lob
    @Column(name = "especificaciones")
    private String especificaciones;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

}