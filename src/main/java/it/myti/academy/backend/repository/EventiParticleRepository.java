package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.EventoParticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by david at 2019-03-11
 */
public interface EventiParticleRepository extends JpaRepository<EventoParticle, Long> {

    EventoParticle findFirstByOrderByRicevutoIlDesc();

}
