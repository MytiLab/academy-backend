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
import java.util.List;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity(name = "unita_logistiche")
public class UnitaLogistica {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(unique = true, length = 10)
    protected String codice;

    @Column(name = "id_esterno", unique = true)
    protected String idEsterno;

    @Column(name = "temp_massima")
    protected Short temperatureMassima;

    @Column(name = "temp_minima")
    protected Short temperaturaMinima;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "stato_id")
    protected StatoUnitaLogistica stato;

    @JsonBackReference
    @Column
    @OneToMany(mappedBy = "unitaLogistica")
    protected List<Collo> spedizioniFatte;

}
