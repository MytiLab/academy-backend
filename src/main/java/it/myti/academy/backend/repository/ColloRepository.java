package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by david at 2019-02-20
 */
@Repository
public interface ColloRepository extends JpaRepository<Collo, Long> {
    List<Collo> findAllByUtente(Utente utente);

    @Query(value = "SELECT * FROM colli WHERE (utente_id = :utente) and (:spedizione is null or spedizione_id = :spedizione) and (:unitaLogistica is null or unita_logistica_id = :unitaLogistica)", nativeQuery = true)
    List<Collo> findAllByUtenteAndSpedizioneAndUnitaLogistica(Long utente, Long spedizione, Long unitaLogistica);
}
