package it.myti.academy.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Column(length = 2)
    protected String unitaDiMisura;

    @ManyToOne
    @JoinColumn(name = "collo_id")
    protected Collo collo;
}
