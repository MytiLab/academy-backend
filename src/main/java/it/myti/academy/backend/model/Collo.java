package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "colli")
public class Collo {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "unita_logistica_id")
    @JsonIgnore
    protected UnitaLogistica unitaLogistica;

    @ManyToOne
    @JoinColumn(name = "spedizione_id")
    @JsonIgnore
    protected Spedizione spedizione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    @JsonIgnore
    protected Utente utente;

    @Column
    @OneToMany(mappedBy = "collo")
    protected List<Contenuto> contenuti;

    @Column
    @OneToMany(mappedBy = "collo")
    protected List<Evento> eventi;

}
