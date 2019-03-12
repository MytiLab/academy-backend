package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.errori.ColloNonTrovatoException;
import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.model.Collo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by david at 2019-02-20
 */
@Service
public class ColloServiceImpl implements ColloService {
    @Autowired
    private ColloRepository colloRepository;

    @Override
    public List<Collo> getSpedizioniAttiveByUtente(Utente utente) throws SpedizioniAttiveNonTrovateException {
        final List<Collo> allByUtente = colloRepository.findAllByUtente(utente);
        List<Collo> risultato = allByUtente.stream()
                .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                .collect(Collectors.toList());
        if(risultato.size() == 0)
            throw new SpedizioniAttiveNonTrovateException();
        return risultato;
    }

    public Collo getSpedizioneAttivaByUtenteAndUnitaLogistica(Utente utente, UnitaLogistica unitaLogistica) throws SpedizioniAttiveNonTrovateException {
        final List<Collo> colliUtenteUnitaLogistica = colloRepository.findAllByUtenteAndUnitaLogistica(utente, unitaLogistica);
        List<Collo> SpedizioniAttive = colliUtenteUnitaLogistica.stream()
                .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                .collect(Collectors.toList());
        if(SpedizioniAttive.size() == 0)
            throw  new SpedizioniAttiveNonTrovateException();
        return SpedizioniAttive.get(0);

    }
}
