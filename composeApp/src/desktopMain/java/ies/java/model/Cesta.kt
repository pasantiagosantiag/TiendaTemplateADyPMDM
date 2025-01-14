package ies.java.model

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(name = "cesta")
open class Cesta {
    @EmbeddedId
    open var id: CestaId? = null

    @MapsId("articulo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "articulo", nullable = false)
    open var articulo: Articulo? = null

    @Column(name = "fecha")
    open var fecha: Instant? = null
}