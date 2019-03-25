package it.myti.academy.backend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UtentiController.class)
public class UtentiControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void sign_up() throws Exception {
        mvc.perform(get("/utenti/sign-up").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}