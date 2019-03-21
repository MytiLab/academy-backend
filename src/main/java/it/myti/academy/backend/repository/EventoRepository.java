package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findTopByOrderByIdDesc();
}
