package it.myti.academy.backend.service;


import it.myti.academy.backend.model.entitaRisposte.DettagliUnitaLogisticaUtente;
import it.myti.academy.backend.model.errori.ColloNonTrovatoException;
import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
import it.myti.academy.backend.model.errori.UnitaLogisticaNonTrovataException;
import it.myti.academy.backend.model.errori.UtenteNonTrovatoException;

import java.util.List;

public interface UnitaLogisticaService {
    List<DettagliUnitaLogisticaUtente> getByUtente(Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException, SpedizioniAttiveNonTrovateException;
    DettagliUnitaLogisticaUtente getByIdAndUtente(Long idUnitaLogistica, Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException, ColloNonTrovatoException, SpedizioniAttiveNonTrovateException;
}
