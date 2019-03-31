package it.myti.academy.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true, length = 64)
    protected String username;

    @Column(length = 64)
    protected String password;

    @Column(length = 64, nullable = false)
    protected String nome;

    @Column
    @OneToMany(mappedBy = "utente")
    protected List<Collo> spedizioniFatte;

}
