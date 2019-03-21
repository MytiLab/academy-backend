package it.myti.academy.backend.service;

import it.myti.academy.backend.model.*;
import it.myti.academy.backend.model.resp.UnitaLogisticaDettaglio;

import java.util.List;

public interface UnitaLogisticaService {
    List<UnitaLogistica> getUnitaLogisticheInViaggioByUtente(Utente utente);
    UnitaLogisticaDettaglio getUnitaLogisticaDetail(Long id);
    Spedizione getSpedizioneCorrente(UnitaLogistica u);
    EventoParticle getLatestEvento(UnitaLogistica u);
}
