package ies.java.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class LocalidadId : Serializable {
    @Column(name = "codm", nullable = false, length = 4)
    open var codm: String? = null

    @Column(name = "provincia", nullable = false, length = 2)
    open var provincia: String? = null
    override fun hashCode(): Int = Objects.hash(codm, provincia)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as LocalidadId

        return codm == other.codm &&
                provincia == other.provincia
    }

    companion object {
        private const val serialVersionUID = 8896140837545460940L
    }
}