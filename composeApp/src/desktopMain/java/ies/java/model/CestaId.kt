package ies.java.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class CestaId : Serializable {
    @Column(name = "articulo", nullable = false, length = 7)
    open var articulo: String? = null

    @Column(name = "usuario", nullable = false, length = 50)
    open var usuario: String? = null
    override fun hashCode(): Int = Objects.hash(articulo, usuario)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as CestaId

        return articulo == other.articulo &&
                usuario == other.usuario
    }

    companion object {
        private const val serialVersionUID = -8120969969343397184L
    }
}