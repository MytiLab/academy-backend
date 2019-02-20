package it.myti.academy.backend.model;

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
@DiscriminatorValue("1")
@Table(name = "eventi_particle")
public class EventoParticle extends Evento {

    @Column(scale = 2)
    protected Double temperatura;

    @Column(scale = 2)
    protected Double umidita;

    @Column(name = "porta_aperta")
    protected boolean portaAperta;

    @Column
    protected Double latitudine;

    @Column
    protected Double longitudine;

    @Column
    protected Double accuratezza;
}
