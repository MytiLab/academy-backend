package it.myti.academy.backend.controller;

        import it.myti.academy.backend.model.UnitaLogistica;
        import it.myti.academy.backend.model.Utente;
        import it.myti.academy.backend.model.entitaRisposte.DettagliUnitaLogisticaUtente;
        import it.myti.academy.backend.model.errori.ColloNonTrovatoException;
        import it.myti.academy.backend.model.errori.SpedizioniAttiveNonTrovateException;
        import it.myti.academy.backend.model.errori.UnitaLogisticaNonTrovataException;
        import it.myti.academy.backend.model.errori.UtenteNonTrovatoException;
        import it.myti.academy.backend.service.UnitaLogisticaService;
        import it.myti.academy.backend.service.UtenteService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;
        import java.util.List;

@RestController
public class UnitaLogisticheController {

    @Autowired
    UnitaLogisticaService unitaLogisticaService;

    @Autowired
    UtenteService utenteService;

    @GetMapping("unitalogistiche/utente/{idUtente}")
    public List<DettagliUnitaLogisticaUtente> getUnitaLogisticheByUtente(@PathVariable("idUtente") Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException, SpedizioniAttiveNonTrovateException {
        return unitaLogisticaService.getByUtente(idUtente);
    }

    @GetMapping("unitalogistiche/{idUnitaLogistica}/utente/{idUtente}")
    public DettagliUnitaLogisticaUtente geUnitaLogisticaByIdAndUtente(@PathVariable("idUnitaLogistica") Long idUnitaLogistica, @PathVariable("idUtente") Long idUtente) throws UnitaLogisticaNonTrovataException, UtenteNonTrovatoException, ColloNonTrovatoException, SpedizioniAttiveNonTrovateException {
        return unitaLogisticaService.getByIdAndUtente(idUnitaLogistica, idUtente);
    }


}
