package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Evento;

import java.util.List;

public interface EventoService {
    List<Evento> getEventiByUtenteAndSpedizioneAndUnitaLogistica(Long idUtente, Long idSpedizione, Long idUnitaLogistica);
}
