package it.myti.academy.backend.controller;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UnitaLogisticheControllerTest extends Controller_setup{

    @Test
    @WithMockUser("SPRINGTEST")
    public void getByUtenteTest() throws Exception {
        mvc.perform(
                get("/unitalogistiche/")
        ).andExpect(status().isOk());
    }

    @Test
    public void getByUtenteTest_notlogged() throws Exception {
        mvc.perform(
                get("/unitalogistiche/")
        ).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser("SPRINGTEST")
    public void getById() throws Exception {
        mvc.perform(
                get("/unitalogistiche/1")
        ).andExpect(status().isOk());
    }
}
