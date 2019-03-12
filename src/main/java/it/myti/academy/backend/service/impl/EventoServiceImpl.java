package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    ColloService colloService;

    @Override
    public List<Evento> findEventiAttiviByUtente(Utente utente) throws SpedizioniAttiveNonTrovateException {
        List<Collo> colliUtente = colloService.getSpedizioniAttiveByUtente(utente);
        List<Evento> eventi = new ArrayList<>();
        colliUtente.forEach(collo -> {
            collo.getEventi().forEach(evento -> {
                eventi.add(evento);
            });
        });
        return eventi;
    }
}
