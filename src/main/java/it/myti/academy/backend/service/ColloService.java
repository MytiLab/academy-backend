package it.myti.academy.backend.service;

import it.myti.academy.backend.model.Collo;

import java.util.List;

/**
 * Created by david at 2019-02-20
 */
public interface ColloService {
    List<Collo> getSpedizioniAttiveByUtente(Long utenteId);
}
