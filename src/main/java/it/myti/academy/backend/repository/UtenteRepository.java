package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by david at 2019-02-20
 */
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}
