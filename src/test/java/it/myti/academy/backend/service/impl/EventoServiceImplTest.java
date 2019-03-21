package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.EventoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EventoServiceImplTest {

    @TestConfiguration
    static class __ {

        private final ColloRepository collo;

        @Autowired
        public __(ColloRepository collo){
            this.collo = collo;
        }

        @Bean
        public EventoService init() {
            return new EventoServiceImpl(collo);
        }
    }

    @Autowired
    UtenteRepository utenti;

    @Autowired
    EventoService eventi; //It says it's an error but it works ¯\_(ツ)_/¯

    @Test
    public void getEventiByUtente() {
        Utente u = utenti.findById(1L).get();
        assertNotNull(u);
        List<Evento> evt = eventi.getEventiByUtente(u, 1L, 1L);
        assertNotNull(evt);
        assertFalse(evt.isEmpty());

        //TODO: Check contenuto
    }
}