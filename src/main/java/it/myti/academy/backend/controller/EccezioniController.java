package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.entitaRisposte.DettagliUnitaLogisticaUtente;
import it.myti.academy.backend.model.errori.*;
import it.myti.academy.backend.model.errori.eccezioni.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class EccezioniController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnitaLogisticaNonTrovataException.class)
    public final DettagliErrore gestisciErrore(UnitaLogisticaNonTrovataException e) {
        return new DettagliErrore(HttpStatus.NOT_FOUND.value(), "Unità logistica non trovata");
    }

    @ExceptionHandler(UtenteNonTrovatoException.class)
    public final DettagliErrore gestisciErrore(UtenteNonTrovatoException e) {
        return new DettagliErrore(HttpStatus.NOT_FOUND.value(), "Utente non trovato.");
    }


    @ExceptionHandler(UtenteNonAutorizzatoException.class)
    public final DettagliErrore gestisciErrore(UtenteNonAutorizzatoException e){
        return new DettagliErrore(HttpStatus.UNAUTHORIZED.value(), "Utente non autorizzato");
    }

    @ExceptionHandler(RegistrazioneException.class)
    public final DettagliErrore gestisciErrore(RegistrazioneException e){
        return new DettagliErrore(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Errore durante la registrazione");
    }
}