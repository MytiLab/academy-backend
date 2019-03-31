package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonTrovatoException;


public interface UtenteService {
    Utente getById(Long id) throws UtenteNonTrovatoException;
    Utente getByUsername(String username);
}
