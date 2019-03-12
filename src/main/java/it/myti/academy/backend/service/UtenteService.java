package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.UtenteNonTrovatoException;
import it.myti.academy.backend.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UtenteService {
    Utente getById(Long id) throws UtenteNonTrovatoException;
}
