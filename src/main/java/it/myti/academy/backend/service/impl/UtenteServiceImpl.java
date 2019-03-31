package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.eccezioni.UtenteNonTrovatoException;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public Utente getById(Long id) throws UtenteNonTrovatoException {
        Utente utente = utenteRepository.getById(id);
        if(utente == null)
            throw new UtenteNonTrovatoException();
        return utente;
    }

    @Override
    public Utente getByUsername(String username) {
        return utenteRepository.getByUsername(username);
    }
}
