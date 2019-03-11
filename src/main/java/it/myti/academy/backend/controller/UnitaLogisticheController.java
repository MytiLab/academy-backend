package it.myti.academy.backend.controller;

        import it.myti.academy.backend.model.*;
        import it.myti.academy.backend.model.dettagli.DettagliUnitaLogisticaUtente;
        import it.myti.academy.backend.repository.ColloRepository;
        import it.myti.academy.backend.repository.UnitaLogisticaRepository;
        import it.myti.academy.backend.repository.UtenteRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;
        import java.util.List;
        import java.util.stream.Collectors;

@RestController
public class UnitaLogisticheController {

    @Autowired
    UnitaLogisticaRepository unitaLogisticaRepository;

    @Autowired
    ColloRepository colloRepository;

    @Autowired
    UtenteRepository utenteRepository;


    @GetMapping("unitalogistiche/utente/{id}")
    public List<DettagliUnitaLogisticaUtente> getAllByUtente(@PathVariable("id") Long id){
        Utente utente = utenteRepository.getById(id);
        List<Collo> colliUtente = colloRepository.findAllByUtente(utente);
        return colliUtente.stream().map(collo -> {
            List<Contenuto> contenutiBase = collo.getContenuti().stream().map(contenuto -> {
                ContenutoBase contenutoBase = new ContenutoBase();
                contenutoBase.setDescrizione(contenuto.getDescrizione());
                contenutoBase.setId(contenuto.getId());
                contenutoBase.setNome(contenuto.getNome());
                contenutoBase.setQuantita(contenuto.getQuantita());
                contenutoBase.setTempMaxRichiesta(contenuto.getTempMaxRichiesta());
                contenutoBase.setTempMinRichiesta(contenuto.getTempMinRichiesta());
                contenutoBase.setUnitaDiMisura(contenuto.getUnitaDiMisura());
                return contenutoBase;
            }).collect(Collectors.toList());
            EventoParticle evento = (EventoParticle) collo.getEventi().get(collo.getEventi().size() - 1);
            DettagliUnitaLogisticaUtente dettagliUnitaLogisticaUtente = new DettagliUnitaLogisticaUtente();
            dettagliUnitaLogisticaUtente.setId(collo.getUnitaLogistica().getId());
            dettagliUnitaLogisticaUtente.setNome(collo.getUnitaLogistica().getCodice());
            dettagliUnitaLogisticaUtente.setLatitudine(evento.getLatitudine().toString());
            dettagliUnitaLogisticaUtente.setLongitudine(evento.getLongitudine().toString());
            dettagliUnitaLogisticaUtente.setUmidita(evento.getUmidita());
            dettagliUnitaLogisticaUtente.setSpedizione(collo.getSpedizione());
            dettagliUnitaLogisticaUtente.setStatus(collo.getUnitaLogistica().getStato());
            dettagliUnitaLogisticaUtente.setTemperatura(evento.getTemperatura());
            dettagliUnitaLogisticaUtente.setContenuti(contenutiBase);
            return dettagliUnitaLogisticaUtente;
        }).collect(Collectors.toList());
    }


}
