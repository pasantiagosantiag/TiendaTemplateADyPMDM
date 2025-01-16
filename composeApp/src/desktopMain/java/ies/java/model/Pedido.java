package ies.java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(name = "pedido")
public class Pedido {
  /*  @Id
    @Column(name = "numPedido", nullable = false)
    private Integer id;*/

    /*@NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;*/
    private String usuario;

    @NotNull

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @NotNull
    @Id
    @Column(name = "numPedido", nullable = false)
    private Integer num_pedido;

  /*  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

   /* public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/
   public String getUsuario() {
       return usuario;
   }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public Integer getNumPedido() {
        return num_pedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.num_pedido = num_pedido;
    }

}