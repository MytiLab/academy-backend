package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.*;
import it.myti.academy.backend.repository.EventoRepository;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.ColloService;
import it.myti.academy.backend.service.EventoService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UnitaLogisticaServiceImplTest {

    @TestConfiguration
    static class __ {
        @Bean
        public ColloService collo_init() {
            return new ColloServiceImpl();
        }

        @Bean
        public UnitaLogisticaService ul_init() {
            return new UnitaLogisticaServiceImpl();
        }
    }

    @Autowired
    UtenteRepository utenti;

    @Autowired
    UnitaLogisticaService uls; //It says it's an error but it works ¯\_(ツ)_/¯

    @Test
    public void getUnitaLogisticheInViaggioByUtente() {
        Utente u = utenti.findById(1L).get();
        assertNotNull(u);
        List<UnitaLogistica> ul = uls.getUnitaLogisticheInViaggioByUtente(u);
        assertNotNull(ul);
        assertFalse(ul.isEmpty());

        //TODO: Check contenuto
    }

    @Test
    public void getUnitaLogisticaDetail(){
        UnitaLogisticaDettaglio ul = uls.getUnitaLogisticaDetail(1L);
        assertNotNull(ul);

        //TODO: checks and co
    }

    @Test
    public void getSpedizioneCorrente(){
        UnitaLogisticaDettaglio ul = uls.getUnitaLogisticaDetail(1L);
        Spedizione s = uls.getSpedizioneCorrente(ul.ref);
        assertNotNull(s);
        assertTrue(s.getArrivoIl().after(new Date()));
    }

    @Test
    public void getLatestEvento(){
        UnitaLogisticaDettaglio ul = uls.getUnitaLogisticaDetail(1L);
        Evento e = uls.getLatestEvento(ul.ref);
        assertNotNull(e);
    }
}