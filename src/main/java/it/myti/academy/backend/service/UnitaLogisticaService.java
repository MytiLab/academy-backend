package it.myti.academy.backend.service;

import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;

import java.util.List;

public interface UnitaLogisticaService {
    List<UnitaLogistica> getUnitaLogisticheInViaggioByUtente(Utente utente);
}
