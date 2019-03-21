package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "tipologie_eventi")
public class EventoTipo {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(unique = true, length = 64)
    protected String nome;

    @Column(length = 2048)
    protected String descrizione;

    @JsonIgnore
    @OneToMany(mappedBy = "tipo")
    protected List<Evento> eventi;
}
