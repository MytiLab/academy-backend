package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "contenuti")
public class Contenuto {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    protected String nome;

    @Column(length = 2048)
    protected String descrizione;

    @Column(name = "temperatura_minima_ricchiesta")
    protected Short tempMinRichiesta;

    @Column(name = "temperatura_massima_ricchiesta")
    protected Short tempMaxRichiesta;

    @Column(scale = 2)
    protected Double quantita;

    @Column(length = 2, name = "unita_di_misura")
    protected String unitaDiMisura;

    @ManyToOne
    @JoinColumn(name = "collo_id")
    @JsonIgnore
    protected Collo collo;
}
