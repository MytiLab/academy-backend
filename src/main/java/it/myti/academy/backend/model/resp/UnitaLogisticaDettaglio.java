package it.myti.academy.backend.model.resp;

import it.myti.academy.backend.model.Contenuto;
import it.myti.academy.backend.model.Spedizione;
import it.myti.academy.backend.model.StatoUnitaLogistica;
import it.myti.academy.backend.model.UnitaLogistica;

import java.util.List;

public class UnitaLogisticaDettaglio {

    public UnitaLogistica ref;
    private List<Contenuto> contenuto;
    private Long id;
    private String nome;
    private StatoUnitaLogistica stato;
    private Double temperatura;
    private Double umidita;
    private String longitudine;
    private String latitudine;
    private Spedizione spedizione;

    public UnitaLogisticaDettaglio(
            UnitaLogistica ref,
            List<Contenuto> contenuto,
            Long id,
            String nome,
            StatoUnitaLogistica stato,
            Double temperatura,
            Double umidita,
            String longitudine,
            String latitudine,
            Spedizione spedizione
    ) {
        this.ref = ref;
        this.contenuto = contenuto;
        this.id = id;
        this.nome = nome;
        this.stato = stato;
        this.temperatura = temperatura;
        this.umidita = umidita;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
        this.spedizione = spedizione;
    }

    public List<Contenuto> getContenuto() {
        return contenuto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatoUnitaLogistica getStato() {
        return stato;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Double getUmidita() {
        return umidita;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public Spedizione getSpedizione() {
        return spedizione;
    }

}
