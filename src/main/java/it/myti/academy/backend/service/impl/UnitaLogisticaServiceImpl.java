package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.*;
import it.myti.academy.backend.model.entitaRisposte.DettagliUnitaLogisticaUtente;
import it.myti.academy.backend.model.errori.ColloNonTrovatoException;
import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
import it.myti.academy.backend.model.errori.UnitaLogisticaNonTrovataException;
import it.myti.academy.backend.model.errori.UtenteNonTrovatoException;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.ContenutoService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import it.myti.academy.backend.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitaLogisticaServiceImpl implements UnitaLogisticaService {
    @Autowired
    UtenteService utenteService;

    @Autowired
    UnitaLogisticaRepository unitaLogisticaRepository;

    @Autowired
    ColloService colloService;

    @Autowired
    ContenutoService contenutoService;


    public List<DettagliUnitaLogisticaUtente> getByUtente(Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException, SpedizioniAttiveNonTrovateException {
        Utente utente = utenteService.getById(idUtente);
        if(utente == null)
            throw new UtenteNonTrovatoException();
        List<Collo> colliUtente = colloService.getSpedizioniAttiveByUtente(utente);
        if (colliUtente.isEmpty())
            throw new UnitaLogisticaNonTrovataException();
        return colliUtente.stream().map(collo -> {
            return generaDettagliRichiestaUnitaByCollo(collo);
        }).collect(Collectors.toList());
    }

    public DettagliUnitaLogisticaUtente getByIdAndUtente(Long idUnitaLogistica, Long idUtente) throws UtenteNonTrovatoException, SpedizioniAttiveNonTrovateException {
        Utente utente = utenteService.getById(idUtente);
        UnitaLogistica unitaLogistica = unitaLogisticaRepository.getById(idUnitaLogistica);
        Collo colloUtente = colloService.getSpedizioneAttivaByUtenteAndUnitaLogistica(utente, unitaLogistica);
        return generaDettagliRichiestaUnitaByCollo(colloUtente);
    }





    private DettagliUnitaLogisticaUtente generaDettagliRichiestaUnitaByCollo(Collo collo){
        List<Contenuto> contenutiBase = contenutoService.generaContenutoBaseByCollo(collo);
        EventoParticle evento = (EventoParticle) collo.getEventi().get(collo.getEventi().size() - 1);
        DettagliUnitaLogisticaUtente dettagliUnitaLogisticaUtente = new DettagliUnitaLogisticaUtente();
        dettagliUnitaLogisticaUtente.setNome(collo.getUnitaLogistica().getCodice());
        dettagliUnitaLogisticaUtente.setId(collo.getUnitaLogistica().getId());
        dettagliUnitaLogisticaUtente.setLatitudine(evento.getLatitudine().toString());
        dettagliUnitaLogisticaUtente.setLongitudine(evento.getLongitudine().toString());
        dettagliUnitaLogisticaUtente.setUmidita(evento.getUmidita());
        dettagliUnitaLogisticaUtente.setSpedizione(collo.getSpedizione());
        dettagliUnitaLogisticaUtente.setStatus(collo.getUnitaLogistica().getStato());
        dettagliUnitaLogisticaUtente.setTemperatura(evento.getTemperatura());
        dettagliUnitaLogisticaUtente.setContenuti(contenutiBase);
        return dettagliUnitaLogisticaUtente;
    }


}
