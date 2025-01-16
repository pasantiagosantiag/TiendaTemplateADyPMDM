package ies.java.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity
@Table(name = "usuario")
open class Usuario {
    @Id
    @Size(max = 50)
    @Column(name = "email", nullable = false, length = 50)
    open var email: String? = null

    @Size(max = 35)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 35)
    open var nombre: String? = null

    @Size(max = 55)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 55)
    open var apellidos: String? = null

    @Size(max = 12)
    @NotNull
    @Column(name = "dni", nullable = false, length = 12)
    open var dni: String? = null

    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    open var telefono: String? = null

    @Size(max = 45)
    @Column(name = "calle", length = 45)
    open var calle: String? = null

    @Size(max = 45)
    @Column(name = "calle2", length = 45)
    open var calle2: String? = null

    @Size(max = 5)
    @Column(name = "codpos", length = 5)
    open var codpos: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    open var localidad: Localidad? = null

    @Column(name = "nacido")
    open var nacido: LocalDate? = null

    @OneToMany(mappedBy = "usuario")
    open var pedidos: MutableSet<Pedido> = mutableSetOf()
}