package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Utente;

import java.util.List;

public interface EventoService {
    List<Evento> findEventiAttiviByUtente(Utente utente);
}
