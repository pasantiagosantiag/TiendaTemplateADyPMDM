package ies.java.model

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "localidad")
open class Localidad {
    @EmbeddedId
    open var id: LocalidadId? = null

    @Column(name = "pueblo", nullable = false, length = 50)
    open var pueblo: String? = null
}