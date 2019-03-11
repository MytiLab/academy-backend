package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity()
@Table(name = "stati_unita_logistiche")
public class StatoUnitaLogistica {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(unique = true, length = 128)
    protected String nome;


    @Column(length = 2048)
    protected String descrizione;

    @JsonBackReference
    @OneToMany(mappedBy = "stato")
    protected List<UnitaLogistica> unitaLogistiche;

}
