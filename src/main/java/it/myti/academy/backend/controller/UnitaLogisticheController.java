package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.entitaRisposte.DettagliUnitaLogisticaUtente;
import it.myti.academy.backend.model.errori.eccezioni.UnitaLogisticaNonTrovataException;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonAutorizzatoException;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonTrovatoException;
import it.myti.academy.backend.service.UnitaLogisticaService;
import it.myti.academy.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UnitaLogisticheController {

    @Autowired
    UnitaLogisticaService unitaLogisticaService;

    @Autowired
    UtenteService utenteService;

    @GetMapping("unitalogistiche/utente/{idUtente}")
    public List<DettagliUnitaLogisticaUtente> getUnitaLogisticheByUtente(@PathVariable("idUtente") Long idUtente) throws UtenteNonAutorizzatoException, UnitaLogisticaNonTrovataException, UtenteNonTrovatoException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Utente utente = utenteService.getByUsername(username);
        if(utente.getId().equals(idUtente) || username == null)
            return unitaLogisticaService.getByUtente(idUtente);
        throw new UtenteNonAutorizzatoException();
    }

    @GetMapping("unitalogistiche/{idUnitaLogistica}/utente/{idUtente}")
    public DettagliUnitaLogisticaUtente geUnitaLogisticaByIdAndUtente(@PathVariable("idUnitaLogistica") Long idUnitaLogistica, @PathVariable("idUtente") Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException, UtenteNonAutorizzatoException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Utente utente = utenteService.getByUsername(username);
        if(utente.getId().equals(idUtente) || username == null)
            return unitaLogisticaService.getByIdAndUtente(idUnitaLogistica, idUtente);
        throw new UtenteNonAutorizzatoException();
    }


}