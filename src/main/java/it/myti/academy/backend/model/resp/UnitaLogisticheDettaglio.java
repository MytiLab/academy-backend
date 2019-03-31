package it.myti.academy.backend.model.resp;

import it.myti.academy.backend.model.Contenuto;
import it.myti.academy.backend.model.EventoParticle;
import it.myti.academy.backend.model.Spedizione;
import it.myti.academy.backend.model.StatoUnitaLogistica;
import lombok.Data;

import java.util.List;

/**
 * Created by david at 2019-03-11
 */
@Data
public class UnitaLogisticheDettaglio {

    protected Long id;
    protected String nome;
    protected StatoUnitaLogistica status;
    protected String latitudine;
    protected String longitudine;
    protected Double temperatura;
    protected Double umidità;
    protected Spedizione spedizione;
    protected List<Contenuto> contenuto;


    public void fillByEventoParticle(EventoParticle event) {
        latitudine = String.valueOf(event.getLatitudine());
        longitudine = String.valueOf(event.getLongitudine());
        temperatura = event.getTemperatura();
        umidità = event.getUmidita();
    }

//    public void setStatus(StatoUnitaLogistica status) {
//        this.status = new StatoUnitaLogistica();
//        this.status.setId(status.getId());
//        this.status.setNome(status.getNome());
//        this.status.setDescrizione(status.getDescrizione());
//    }
//
//    public void setSpedizione(Spedizione s) {
//        this.spedizione = new Spedizione();
//        spedizione.setId(s.getId());
//        spedizione.setPartenzaDa(s.getPartenzaDa());
//        spedizione.setPartenzaIl(s.getPartenzaIl());
//        spedizione.setArrivoA(s.getArrivoA());
//        spedizione.setArrivoIl(s.getArrivoIl());
//        spedizione.setCodiceTreno(s.getCodiceTreno());
//    }
//
//    public void setContenuto(List<Contenuto> contenuto) {
//        this.contenuto = contenuto.stream()
//            .map( c -> {
//                Contenuto t = new Contenuto();
//                t.setId(c.getId());
//                t.setNome(c.getNome());
//                t.setDescrizione(c.getDescrizione());
//                t.setQuantita(c.getQuantita());
//                t.setUnitaDiMisura(c.getUnitaDiMisura());
//                t.setTempMaxRichiesta(c.getTempMaxRichiesta());
//                t.setTempMinRichiesta(c.getTempMinRichiesta());
//                return t;
//            })
//            .collect(Collectors.toList());
//    }
}
