package it.myti.accademy.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by david at 2019-02-13
 */

@Data
@Entity
@DiscriminatorValue("2")
@Table(name = "eventi_hannibal")
public class EventoHannibal extends Evento {

    @Column(name = "codice_evento")
    protected String codiceEvento;

    @Column(name = "codice_treno")
    protected String codiceTreno;

}
