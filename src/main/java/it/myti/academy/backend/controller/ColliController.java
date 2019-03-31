package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonTrovatoException;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by david at 2019-03-07
 */
@RestController
public class ColliController {

    @Autowired
    ColloService colloService;

    @Autowired
    UtenteService utenteService;

    @GetMapping("/collo/utente/{id}")
    public List<Collo> getByUtente(@PathVariable("id") long id) throws UtenteNonTrovatoException {


        List<Collo> returnValue = null;

        final Utente utente = utenteService.getById(id);
        if(utente!=null) {
            returnValue = colloService.getSpedizioniAttiveByUtente(utente);
        }

        return returnValue;
    }

}
