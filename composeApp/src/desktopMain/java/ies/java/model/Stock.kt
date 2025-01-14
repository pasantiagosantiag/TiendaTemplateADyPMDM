package ies.java.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "stock")
open class Stock {
    @Id
    @Column(name = "articulo", nullable = false, length = 7)
    open var articulo: String? = null

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "articulo", nullable = false)
    open var articulo1: Articulo? = null

    @Column(name = "disponible")
    open var disponible: Int? = null

    @Lob
    @Column(name = "entrega")
    open var entrega: String? = null
}