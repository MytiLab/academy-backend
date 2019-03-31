package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by david at 2019-03-11
 */
@RestController
public class EventiController {

    @Autowired
    public EventoService eventoService;

    @GetMapping("/eventi/utente/{id}")
    public List<Evento> getEventiByUtente(@PathVariable("id") Long idUtente, @RequestParam(value = "idSpedizione", required = false) Long idSpedizione, @RequestParam(value = "idUnitaLogistica", required = false) Long idUnitaLogistica) {

        final List<Evento> eventiSpedizioniAttiveByUtente = eventoService.getEventiByUtenteAndSpedizioneAndUnitaLogistica(idUtente, idSpedizione, idUnitaLogistica);

        return eventiSpedizioniAttiveByUtente;
    }
}
