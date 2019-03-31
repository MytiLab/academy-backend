package it.myti.academy.backend.service;


import it.myti.academy.backend.model.entitaRisposte.DettagliUnitaLogisticaUtente;
import it.myti.academy.backend.model.errori.eccezioni.UnitaLogisticaNonTrovataException;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonTrovatoException;

import java.util.List;

public interface UnitaLogisticaService {
    List<DettagliUnitaLogisticaUtente> getByUtente(Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException;
    DettagliUnitaLogisticaUtente getByIdAndUtente(Long idUnitaLogistica, Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException;
}
