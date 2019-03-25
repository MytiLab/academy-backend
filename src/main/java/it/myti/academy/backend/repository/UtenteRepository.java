package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david at 2019-02-20
 */
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Utente findByUsername(String username);
}
