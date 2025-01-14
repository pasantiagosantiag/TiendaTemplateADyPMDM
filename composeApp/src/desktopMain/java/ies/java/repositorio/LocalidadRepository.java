package ies.java.repositorio;

import ies.java.model.Localidad;
import ies.java.model.LocalidadId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadRepository extends JpaRepository<Localidad, LocalidadId> {
}