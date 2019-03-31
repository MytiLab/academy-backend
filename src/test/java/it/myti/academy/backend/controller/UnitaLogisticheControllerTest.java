package it.myti.academy.backend.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitaLogisticheControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void getDettagliByUtente() throws Exception {
        final MockHttpServletRequestBuilder signup = post("/utente/sign-up").contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"admin\", \"password\": \"admin\", \"nome\": \"admin\"}");
        mockMvc.perform(signup)
                .andExpect(status().isOk());

        final MockHttpServletRequestBuilder login = post("/login").contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\": \"admin\", \"password\": \"admin\"}");
        final MvcResult response = mockMvc.perform(login)
                .andExpect(status().isOk())
                .andReturn();
        final String token = "Bearer " + response.getResponse().getHeader("Authorization");

        final MockHttpServletRequestBuilder requestBuilder = get("/unitalogistiche/").header("Authorization", token);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }

    @Test
    public void postDettagliByUtente() throws Exception {
        final MockHttpServletRequestBuilder requestBuilder = post("/unitalogistiche");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isUnauthorized());
    }
}
