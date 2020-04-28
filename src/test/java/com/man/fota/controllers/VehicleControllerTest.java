package com.man.fota.controllers;

import com.man.fota.FotaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = FotaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class VehicleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturn1CompatibleAnd1IncompatibleCompatibleFeatureYIncompatibleZ() throws Exception {
        mvc.perform(get("/vehicles/compatibleFeatureYIncompatibleZ"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.installable", hasSize(1)))
                .andExpect(jsonPath("$.incompatible", hasSize(1)))
                .andExpect(jsonPath("$.installable[0].featureName", is("Y")))
                .andExpect(jsonPath("$.incompatible[0].featureName", is("Z")));
    }

    @Test
    public void shouldReturnFeatureXForCompatibleFeatureX() throws Exception {
        mvc.perform(get("/vehicles/compatibleFeatureX/installable"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].featureName", is("X")));
    }

    @Test
    public void shouldReturnFeatureZForCompatibleFeatureYIncompatibleZ() throws Exception {
        mvc.perform(get("/vehicles/compatibleFeatureYIncompatibleZ/incompatible"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].featureName", is("Z")));
    }

    @Test
    public void getAllVehiclesTest() throws Exception {
        mvc.perform(get("/vehicles/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].vin", is("compatibleFeatureX")))
                .andExpect(jsonPath("$[1].vin", is("compatibleFeatureYAndZ")))
                .andExpect(jsonPath("$[2].vin", is("compatibleFeatureYIncompatibleZ")))
                .andExpect(jsonPath("$[3].vin", is("incompatibleFeatureX")));
    }
}