package it.myti.academy.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by david at 2019-02-13
 */
@Data
@Entity
@Table(name = "contenuti")
public class ContenutoCompleto extends Contenuto{

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "collo_id")
    protected Collo collo;
}
