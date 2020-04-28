package com.man.fota.controllers;

import com.man.fota.dto.AllValues;
import com.man.fota.dto.FeatureDto;
import com.man.fota.dto.VehicleDto;
import com.man.fota.services.FeatureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FeatureController.class)
public class FeatureControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    FeatureService featureService;

    @Test
    public void getVehiclesByFeatureTest() throws Exception {
        AllValues<VehicleDto> allValues = new AllValues<>();
        List<VehicleDto> compatibleList = new ArrayList<>(2);
        compatibleList.add(new VehicleDto("vin1"));
        compatibleList.add(new VehicleDto("vin2"));
        allValues.setInstallable(compatibleList);
        allValues.setIncompatible(Collections.singletonList(new VehicleDto("vin3")));

        when(featureService.getAllVehicles("A")).thenReturn(allValues);

        mvc.perform(get("/features/A"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("vin1")))
                .andExpect(content().string(containsString("vin2")))
                .andExpect(content().string(containsString("vin3")));
    }


    @Test
    public void getAllFeaturesTest() throws Exception {
        List<FeatureDto> expectedList = new ArrayList<>(3);
        expectedList.add(new FeatureDto("A"));
        expectedList.add(new FeatureDto("B"));
        expectedList.add(new FeatureDto("C"));

        when(featureService.getAllFeatures()).thenReturn(expectedList);

        mvc.perform(get("/features/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("A")))
                .andExpect(content().string(containsString("B")))
                .andExpect(content().string(containsString("C")));
    }
}