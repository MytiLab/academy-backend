package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.ColloNonTrovatoException;
import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
import it.myti.academy.backend.model.errori.UnitaLogisticaNonTrovataException;

import java.util.List;

/**
 * Created by david at 2019-02-20
 */
public interface ColloService {
    List<Collo> getSpedizioniAttiveByUtente(Utente utente) throws SpedizioniAttiveNonTrovateException;
    Collo getSpedizioneAttivaByUtenteAndUnitaLogistica(Utente utente, UnitaLogistica unitaLogistica) throws SpedizioniAttiveNonTrovateException;
}
