package ies.java.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "pedido")
open class Pedido {
    @Id
    @Column(name = "numPedido", nullable = false)
    open var id: Int? = null

    @Column(name = "fecha", nullable = false)
    open var fecha: Instant? = null
}