package it.myti.academy.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "spedizioni")
public class Spedizione {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "codice_treno")
    protected String codiceTreno;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "partenza_il", nullable = false)
    protected Date partenzaIl;

    @Column(name = "partenza_da", nullable = false)
    protected String partenzaDa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "arrivo_il", nullable = false)
    protected Date arrivoIl;

    @Column(name = "arrivo_a", nullable = false)
    protected String arrivoA;

    @Column
    @OneToMany(mappedBy = "spedizione")
    protected List<Collo> colliInviati;


}
