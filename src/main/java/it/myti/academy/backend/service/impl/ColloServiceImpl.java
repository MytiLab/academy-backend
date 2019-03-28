package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.ColloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by david at 2019-02-20
 */
@Service
public class ColloServiceImpl implements ColloService {

    private final ColloRepository colloRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    public ColloServiceImpl(ColloRepository colloRepository) {
        this.colloRepository = colloRepository;
    }

    @Override
    public List<Collo> getSpedizioniAttiveByUtente(Long utenteId) {
        final Utente utente = utenteRepository.findById(utenteId).get();
        if (utente != null)
            return getSpedizioniAttiveByUtente(utente);
        return new ArrayList<>();
    }

    @Override
    public List<Collo> getSpedizioniAttiveByUtente(Utente utente) {
        final List<Collo> allByUtente = colloRepository.findAllByUtente(utente);
        return allByUtente.stream()
                .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                .collect(Collectors.toList());
    }
}
