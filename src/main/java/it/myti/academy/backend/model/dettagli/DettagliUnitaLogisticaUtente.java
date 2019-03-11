package it.myti.academy.backend.model.dettagli;

import it.myti.academy.backend.model.Contenuto;
import it.myti.academy.backend.model.Spedizione;
import it.myti.academy.backend.model.StatoUnitaLogistica;
import lombok.Data;

import java.util.List;

@Data
public class DettagliUnitaLogisticaUtente {

    protected Long id;
    protected String nome;
    protected StatoUnitaLogistica status;
    protected String latitudine;
    protected String longitudine;
    protected Double temperatura;
    protected Double umidita;
    protected Spedizione spedizione;
    protected List<Contenuto> contenuti;
}
