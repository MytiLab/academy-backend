package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
import it.myti.academy.backend.model.errori.UtenteNonTrovatoException;
import it.myti.academy.backend.service.EventoService;
import it.myti.academy.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventiController {
    @Autowired
    EventoService eventoService;

    @Autowired
    UtenteService utenteService;

    @GetMapping("/eventi/utente/{idUtente}")
    public List<Evento> getRventiByCollo(@PathVariable("idUtente") Long idUtente) throws UtenteNonTrovatoException, SpedizioniAttiveNonTrovateException {
        return eventoService.findEventiAttiviByUtente(utenteService.getById(idUtente));
    }
}
