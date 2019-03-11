package it.myti.academy.backend.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Inheritance
@Table(name = "contenuti")
abstract public class Contenuto {

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
}
