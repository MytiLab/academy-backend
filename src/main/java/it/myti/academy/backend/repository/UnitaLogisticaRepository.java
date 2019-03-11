package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.UnitaLogistica;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UnitaLogisticaRepository extends JpaRepository<UnitaLogistica, Long> {
    UnitaLogistica getById(Long id);

}
