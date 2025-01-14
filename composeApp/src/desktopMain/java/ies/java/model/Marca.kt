package ies.java.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "marca")
open class Marca {
    @Id
    @Column(name = "marca", nullable = false, length = 15)
    open var marca: String? = null

    @Column(name = "empresa", length = 60)
    open var empresa: String? = null

    @Column(name = "logo")
    open var logo: ByteArray? = null
}