package it.myti.academy.backend.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by david at 2019-02-21
 */
public class UtenteTest {
    public static final long ID = 1L;
    public static final String USERNAME = "FFranchi";
    public static final String PASSWORD = "Franchi";
    public static final String NOME = "Franco";
    Utente u = new Utente();
    private List<Collo> colli;
    private Collo collo;

    @Before
    public void setUp() throws Exception {
        u.setId(ID);
        u.setNome(NOME);
        u.setPassword(PASSWORD);
        u.setUsername(USERNAME);

        colli = new ArrayList<>();
        collo = new Collo();
        colli.add(collo);
        u.setSpedizioniFatte(colli);

    }

    @Test
    public void getId() {
        assertEquals(1L, u.getId().longValue());
    }

    @Test
    public void getUsername() {
        assertEquals(USERNAME, u.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals(PASSWORD, u.getPassword());
    }

    @Test
    public void getNome() {
        assertEquals(NOME, u.getNome());
    }

    @Test
    public void getSpedizioniFatte() {
        assertEquals(colli, u.getSpedizioniFatte());
    }

    @Test
    public void setId() {
        u.setId(2L);
        assertNotEquals(ID, u.getId().longValue());
    }

    @Test
    public void setUsername() {
        u.setUsername("RMario");
        assertNotEquals(USERNAME, u.getUsername());
    }

    @Test
    public void setPassword() {
        u.setPassword("Rossi");
        assertNotEquals(PASSWORD, u.getPassword());
    }

    @Test
    public void setNome() {
        u.setNome("Mario");
        assertNotEquals(NOME, u.getNome());
    }

    @Test
    public void setSpedizioniFatte() {
        u.setSpedizioniFatte(null);
        assertNotEquals(colli, u.getSpedizioniFatte());
    }
}