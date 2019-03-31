package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.EventoParticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by david at 2019-03-11
 */
@Repository
public interface EventiParticleRepository extends JpaRepository<EventoParticle, Long> {

    EventoParticle findFirstByOrderByRicevutoIlDesc();

}
