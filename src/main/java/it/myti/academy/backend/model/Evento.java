package it.myti.academy.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "evento_tipo_dettaglio"
)
public abstract class Evento {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "ricevuto_il", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date ricevutoIl = new Date();

    @ManyToOne
    @JoinColumn(name = "evento_tipo_id")
    protected EventoTipo tipo;

    @ManyToOne
    @JoinColumn(name = "collo_id")
    protected Collo collo;

}
