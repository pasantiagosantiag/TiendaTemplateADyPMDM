package ies.java.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "articulo")
open class Articulo {
    @Id
    @Column(name = "cod", nullable = false, length = 7)
    open var cod: String? = null

    @Column(name = "nombre", length = 45)
    open var nombre: String? = null

    @Column(name = "pvp", precision = 7, scale = 2)
    open var pvp: BigDecimal? = null

    @Column(name = "imagen")
    open var imagen: ByteArray? = null

    @Column(name = "urlimagen", length = 100)
    open var urlimagen: String? = null

    @Lob
    @Column(name = "especificaciones")
    open var especificaciones: String? = null
}