package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private ColloRepository colloRepository;

    @Override
    public List<Evento> getEventiByUtenteAndSpedizioneAndUnitaLogistica(Long idUtente, Long idSpedizione, Long idUnitaLogistica) {
        final List<Collo> colliByUtente = colloRepository.findAllByUtenteAndSpedizioneAndUnitaLogistica(idUtente, idSpedizione, idUnitaLogistica);
        return colliByUtente.stream()
                .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                .flatMap(collo -> collo.getEventi().stream())
                .collect(Collectors.toList());
    }
}
