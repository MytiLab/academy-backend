package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.UnitaLogisticaDettaglio;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitaLogisticaServiceImpl implements UnitaLogisticaService {

    @Autowired
    ColloService colli;

    @Autowired
    UnitaLogisticaRepository ulr;

    @Override
    public List<UnitaLogistica> getUnitaLogisticheInViaggioByUtente(Utente utente) {
        return colli.getSpedizioniAttiveByUtente(utente).stream()
                .map(collo -> collo.getUnitaLogistica())
                .collect(Collectors.toList());
    }

    public UnitaLogisticaDettaglio getUnitaLogisticaDetail(Long id) {
        UnitaLogistica element = ulr.findById(id).get();
         return new UnitaLogisticaDettaglio(element);
    }
}
