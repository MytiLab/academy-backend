package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;

import java.util.List;

/**
 * Created by david at 2019-02-20
 */
public interface ColloService {
    List<Collo> getSpedizioniAttiveByUtente(Long utenteId);
    List<Collo> getSpedizioniAttiveByUtente(Utente utente);
    Collo getSpedizioneAttivaByUtenteAndUnitaLogistica(Utente utente, UnitaLogistica unitaLogistica);
}
