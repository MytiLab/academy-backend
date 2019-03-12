package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.errori.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class EccezioniController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnitaLogisticaNonTrovataException.class)
    public final DettagliErrore gestisciUnitaNonTrovata(UnitaLogisticaNonTrovataException e) {
        return new DettagliErrore(HttpStatus.NOT_FOUND.value(), "Nessuna unità logistica trovata.");
    }

    @ExceptionHandler(UtenteNonTrovatoException.class)
    public final DettagliErrore gestisciUtenteNonTrovato(UtenteNonTrovatoException e) {
        return new DettagliErrore(HttpStatus.NOT_FOUND.value(), "Utente non trovato.");
    }

    @ExceptionHandler(ColloNonTrovatoException.class)
    public final DettagliErrore gestisciUtenteNonTrovato(ColloNonTrovatoException e) {
        return new DettagliErrore(HttpStatus.NOT_FOUND.value(), "Collo non trovato.");
    }

    @ExceptionHandler(SpedizioniAttiveNonTrovateException.class)
    public final DettagliErrore gestisciSpedizioniAttiveNonTrovate(SpedizioniAttiveNonTrovateException e) {
        return new DettagliErrore(HttpStatus.NOT_FOUND.value(), "Non esistono spedizioni attive per l'utente.");
    }
}