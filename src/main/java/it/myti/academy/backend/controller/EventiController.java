package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonAutorizzatoException;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonTrovatoException;
import it.myti.academy.backend.service.EventoService;
import it.myti.academy.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public List<Evento> getEventiByCollo(@PathVariable("idUtente") Long idUtente) throws UtenteNonTrovatoException, UtenteNonAutorizzatoException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Utente utente = utenteService.getByUsername(username);
        if(utente.getId().equals(idUtente) || username == null)
            return eventoService.findEventiAttiviByUtente(utenteService.getById(idUtente));
        throw new UtenteNonAutorizzatoException();

    }
}
