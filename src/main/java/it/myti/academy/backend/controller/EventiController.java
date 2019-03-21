package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eventi")
public class EventiController {

    private final UtenteRepository utenteRepository;
    private final EventoService eventi;

    @Autowired
    public EventiController(UtenteRepository utenteRepository, EventoService eventi) {
        this.utenteRepository = utenteRepository;
        this.eventi = eventi;
    }

    @GetMapping("/utente/{id}")
    public List<Evento> getByUtente(@PathVariable("id") long id, @RequestParam Map<String, String> params) {
        final Utente utente = utenteRepository.findById(id).get();
        if (utente != null) {
            Long spedizione = null;
            Long ul = null;
            try {
                spedizione = params.get("idSpedizione") != null ? Long.parseLong(params.get("idSpedizione")) : null;
                ul = params.get("idUnitaLogistica") != null ? Long.parseLong(params.get("idUnitaLogistica")) : null;
            } catch (NumberFormatException e) {
                spedizione = null;
                ul = null;
            }
            return eventi.getEventiByUtente(utente, spedizione, ul);
        }
        return null;
    }

}
