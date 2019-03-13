package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.*;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitaLogisticaServiceImpl implements UnitaLogisticaService {

    @Autowired
    ColloService colli;

    @Autowired
    UnitaLogisticaRepository ulr;

    @Override
    public List<UnitaLogistica> getUnitaLogisticheInViaggioByUtente(Utente utente) {
        return colli.getSpedizioniAttiveByUtente(utente).stream()
                .map(Collo::getUnitaLogistica)
                .collect(Collectors.toList());
    }

    @Override
    public UnitaLogisticaDettaglio getUnitaLogisticaDetail(Long id) {
        UnitaLogistica element = ulr.findById(id).get();
        EventoParticle e = this.getLatestEvento(element);
         return new UnitaLogisticaDettaglio(
                 element,
                 element.getSpedizioniFatte()
                    .stream()
                    .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                    .map(collo -> collo.getContenuti())
                    .flatMap(x -> x.stream())
                    .collect(Collectors.toList()),
                 element.getId(),
                 element.getCodice(),
                 element.getStato(),
                 e.getTemperatura(),
                 e.getUmidita(),
                 e.getLatitudine().toString(),
                 e.getLongitudine().toString(),
                 this.getSpedizioneCorrente(element)
         );
    }

    @Override
    public Spedizione getSpedizioneCorrente(UnitaLogistica u){
        return ulr.findById(u.getId()).get().getSpedizioniFatte()
                .stream()
                .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                .map(Collo::getSpedizione)
                .findFirst().get();
    }

    @Override
    public EventoParticle getLatestEvento(UnitaLogistica u){
        return (EventoParticle) u.getSpedizioniFatte()
                .stream()
                .filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date()))
                .map(collo -> collo.getEventi()
                        .stream()
                        .filter(element -> element instanceof EventoParticle)
                        .max((a, b) -> a.getRicevutoIl().compareTo(b.getRicevutoIl())).get()
                ).findFirst().get();
    }
}
