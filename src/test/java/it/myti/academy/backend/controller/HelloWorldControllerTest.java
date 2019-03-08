package it.myti.academy.backend.controller;

import it.myti.academy.backend.service.HelloWorldService;
import it.myti.academy.backend.service.impl.HelloWorldServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by david at 2019-02-19
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired //2
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        final String returnString = "Hello";

        final MockHttpServletRequestBuilder requestBuilder = get("/hello").contentType(MediaType.TEXT_PLAIN);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(returnString));
    }

    @Test
    public void helloPOST() throws Exception {
        final String paramStr = "MESSGE";
        final String expected = "Hello " + paramStr + "!";

        final MockHttpServletRequestBuilder requestBuilder = post("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .content(paramStr);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public HelloWorldService employeeService() {
            return new HelloWorldServiceImpl();
        }
    }
}