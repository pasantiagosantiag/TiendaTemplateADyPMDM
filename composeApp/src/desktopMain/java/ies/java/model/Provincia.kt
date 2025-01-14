package ies.java.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "provincia")
open class Provincia {
    @Id
    @Column(name = "codp", nullable = false, length = 2)
    open var codp: String? = null

    @Column(name = "nombre", nullable = false, length = 25)
    open var nombre: String? = null
}