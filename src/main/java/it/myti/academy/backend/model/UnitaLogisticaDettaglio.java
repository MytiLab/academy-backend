package it.myti.academy.backend.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UnitaLogisticaDettaglio extends UnitaLogistica {

    protected List<Collo> contenuto;

    public UnitaLogisticaDettaglio(UnitaLogistica dettagli) {
        this.id = dettagli.id;
        this.codice = dettagli.codice;
        this.idEsterno = dettagli.idEsterno;
        this.temperatureMassima = dettagli.temperatureMassima;
        this.temperaturaMinima = dettagli.temperaturaMinima;
        this.stato = dettagli.stato;
        this.spedizioniFatte = dettagli.spedizioniFatte;
        this.contenuto = dettagli.getSpedizioniFatte().stream().filter(collo -> collo.getSpedizione().getArrivoIl().after(new Date())).collect(Collectors.toList());
    }

    public List<Collo> getContenuto() {
        return contenuto;
    }

}
