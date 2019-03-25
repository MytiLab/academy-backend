package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.resp.UnitaLogisticaDettaglio;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unitalogistiche")
public class UnitaLogisticheController {

    private final UtenteRepository utenteRepository;
    private final UnitaLogisticaService uls;

    @Autowired
    public UnitaLogisticheController(UtenteRepository utenteRepository, UnitaLogisticaService uls) {
        this.utenteRepository = utenteRepository;
        this.uls = uls;
    }

    @GetMapping("/")
    public List<UnitaLogistica> getByUtente() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        final Utente utente = utenteRepository.findByUsername(username);

        if (utente != null)
            return uls.getUnitaLogisticheInViaggioByUtente(utente);
        return null;
    }

    @GetMapping("/{id}")
    public UnitaLogisticaDettaglio getById(@PathVariable("id") long id) {
        return uls.getUnitaLogisticaDetail(id);
    }

}
