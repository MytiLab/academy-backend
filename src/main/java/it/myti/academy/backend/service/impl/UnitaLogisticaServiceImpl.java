package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitaLogisticaServiceImpl implements UnitaLogisticaService {

    @Autowired
    ColloService colli;

    @Override
    public List<UnitaLogistica> getUnitaLogisticheInViaggioByUtente(Utente utente) {
        return colli.getSpedizioniAttiveByUtente(utente).stream()
                .map(collo -> collo.getUnitaLogistica())
                .collect(Collectors.toList());
    }
}
