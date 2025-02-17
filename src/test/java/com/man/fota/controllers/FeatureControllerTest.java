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
public class FeatureControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturn1CompatibleAnd1IncompatibleVehicleForFeatureX() throws Exception {
        mvc.perform(get("/features/X"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.installable", hasSize(1)))
                .andExpect(jsonPath("$.incompatible", hasSize(1)))
                .andExpect(jsonPath("$.installable[0].vin", is("compatibleFeatureX")))
                .andExpect(jsonPath("$.incompatible[0].vin", is("incompatibleFeatureX")));
    }

    @Test
    public void shouldReturn1CompatibleAndVehicleForFeatureX() throws Exception {
        mvc.perform(get("/features/X/installable"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].vin", is("compatibleFeatureX")));
    }

    @Test
    public void shouldReturn1IncompatibleAndVehicleForFeatureZ() throws Exception {
        mvc.perform(get("/features/Z/incompatible"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].vin", is("compatibleFeatureYIncompatibleZ")));
    }

    @Test
    public void getAllFeaturesTest() throws Exception {
        mvc.perform(get("/features/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].featureName", is("X")))
                .andExpect(jsonPath("$[1].featureName", is("Y")))
                .andExpect(jsonPath("$[2].featureName", is("Z")));
    }
}