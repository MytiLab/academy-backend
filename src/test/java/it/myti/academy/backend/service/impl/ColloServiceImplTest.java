package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.Collo;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.ColloRepository;
import it.myti.academy.backend.repository.UtenteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by david at 2019-02-20
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class ColloServiceImplTest {

    @Autowired
    private ColloRepository colloRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Test
    public void getSpedizioniAttiveByUtente() {
        final Utente utente = utenteRepository
                .findById(1L)
                .get();
        assertNotNull(utente);

        final List<Collo> allByUtente = colloRepository.findAllByUtente(utente);
        assertNotNull(allByUtente);
        assertFalse(allByUtente.isEmpty());
    }
}