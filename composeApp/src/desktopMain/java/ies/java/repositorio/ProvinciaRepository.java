package ies.java.repositorio;

import ies.java.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, String> {
}