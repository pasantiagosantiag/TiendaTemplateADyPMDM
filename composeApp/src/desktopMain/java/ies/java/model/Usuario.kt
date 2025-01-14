package ies.java.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "usuario")
open class Usuario {
    @Id
    @Column(name = "email", nullable = false, length = 50)
    open var email: String? = null

    @Column(name = "nombre", nullable = false, length = 35)
    open var nombre: String? = null

    @Column(name = "apellidos", nullable = false, length = 55)
    open var apellidos: String? = null

    @Column(name = "dni", nullable = false, length = 12)
    open var dni: String? = null

    @Column(name = "telefono", length = 15)
    open var telefono: String? = null

    @Column(name = "calle", length = 45)
    open var calle: String? = null

    @Column(name = "calle2", length = 45)
    open var calle2: String? = null

    @Column(name = "codpos", length = 5)
    open var codpos: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    open var localidad: Localidad? = null

    @Column(name = "nacido")
    open var nacido: LocalDate? = null
}