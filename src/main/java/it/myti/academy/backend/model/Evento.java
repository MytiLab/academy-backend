package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
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
    @JsonIgnore
    protected EventoTipo tipo;

    @ManyToOne
    @JoinColumn(name = "collo_id")
    @JsonIgnore
    protected Collo collo;

}
