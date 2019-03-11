package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "unita_logistica_id")
    protected UnitaLogistica unitaLogistica;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "spedizione_id")
    protected Spedizione spedizione;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "utente_id")
    protected Utente utente;

    @JsonBackReference
    @Column
    @OneToMany(mappedBy = "collo")
    protected List<ContenutoCompleto> contenuti;

    @JsonBackReference
    @Column
    @OneToMany(mappedBy = "collo")
    protected List<Evento> eventi;

}
