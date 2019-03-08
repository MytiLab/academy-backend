package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitaLogisticheController {

    @Autowired
    UtenteRepository utenteRepository;

    @Autowired
    UnitaLogisticaService uls;

    @Autowired
    UnitaLogisticaRepository ulr;

    @GetMapping("/unitalogistiche/utente/{id}")
    public List<UnitaLogistica> getByUtente(@PathVariable("id") long id) {
        final Utente utente = utenteRepository.findById(id).get();
        if (utente != null)
            return uls.getUnitaLogisticheInViaggioByUtente(utente);
        return null;
    }

    @GetMapping("/unitalogistiche/{id}")
    public UnitaLogistica getById(@PathVariable("id") long id) {
        return ulr.findById(id).get();
    }

}
