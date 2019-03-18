package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.*;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.EventoRepository;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.EventoService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    private final ColloRepository colli;

    @Autowired
    public EventoServiceImpl(ColloRepository colli) {
        this.colli = colli;
    }

    @Override
    public List<Evento> getEventiByUtente(Utente utente, Long idSpedizione, Long idUL) {
        final List<Collo> allByUtente = colli.findAllByUtente(utente);
        return allByUtente.stream()
                .filter(collo -> idSpedizione == null || collo.getSpedizione().getId().equals(idSpedizione))
                .filter(collo -> idUL == null || collo.getUnitaLogistica().getId().equals(idUL))
                .map(Collo::getEventi)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
