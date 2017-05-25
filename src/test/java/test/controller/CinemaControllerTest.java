package test.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import test.RestControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CinemaControllerTest extends RestControllerTest {

    @Test
    public void testGetCinemaByID() throws Exception {
        mockMvc.perform(get(URI_CINEMA, "1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.*").value(Matchers.hasSize(3)))
            .andExpect(jsonPath("$.cinemaId").value(1))
            .andExpect(jsonPath("$.cinemaName").isString())
            .andExpect(jsonPath("$.cinemaAddr").isString());
    }
}
