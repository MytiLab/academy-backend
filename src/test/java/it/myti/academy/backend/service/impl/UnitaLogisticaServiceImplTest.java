package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Spedizione;
import it.myti.academy.backend.model.UnitaLogistica;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.model.resp.UnitaLogisticaDettaglio;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.ColloService;
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
    public void getUnitaLogisticaDetail() {
        UnitaLogisticaDettaglio ul = uls.getUnitaLogisticaDetail(1L);
        assertNotNull(ul);

        //TODO: checks and co
    }

    @Test
    public void getSpedizioneCorrente() {
        UnitaLogisticaDettaglio ul = uls.getUnitaLogisticaDetail(1L);
        Spedizione s = uls.getSpedizioneCorrente(ul.ref);
        assertNotNull(s);
        assertTrue(s.getArrivoIl().after(new Date()));
    }

    @Test
    public void getLatestEvento() {
        UnitaLogisticaDettaglio ul = uls.getUnitaLogisticaDetail(1L);
        Evento e = uls.getLatestEvento(ul.ref);
        assertNotNull(e);
    }

    @TestConfiguration
    static class __ {

        private final ColloRepository collo;
        private final UnitaLogisticaRepository ulr;

        @Autowired
        public __(ColloRepository collo, UnitaLogisticaRepository ulr) {
            this.collo = collo;
            this.ulr = ulr;
        }

        @Bean
        public ColloService collo_init() {
            return new ColloServiceImpl(collo);
        }

        @Bean
        public UnitaLogisticaService ul_init() {
            return new UnitaLogisticaServiceImpl(collo_init(), ulr);
        }
    }
}