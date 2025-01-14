package ies.java.repositorio;

import ies.java.model.Cesta;
import ies.java.model.CestaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CestaRepository extends JpaRepository<Cesta, CestaId> {
}