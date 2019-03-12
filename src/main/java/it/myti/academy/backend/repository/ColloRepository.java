package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Contenuto;
import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.Collo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by david at 2019-02-20
 */
public interface ColloRepository extends JpaRepository<Collo, Long> {
    List<Collo> findAllByUtente(Utente utente);
    Collo findFirstByUtenteAndUnitaLogistica(Utente utente, UnitaLogistica unitaLogistica);
    List<Collo> findAllByUtenteAndUnitaLogistica(Utente utente, UnitaLogistica unitaLogistica);

}
