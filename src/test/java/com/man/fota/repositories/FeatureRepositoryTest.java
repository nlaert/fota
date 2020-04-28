package com.man.fota.repositories;

import com.man.fota.entities.FeatureEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class FeatureRepositoryTest {

    @Autowired
    private FeatureRepository featureRepository;

    @Test
    public void shouldReturnFeatureXWhenGivenCompatibleFeatureX() {
        List<FeatureEntity> features = featureRepository.getInstallableFeaturesByVin("compatibleFeatureX");
        Assertions.assertEquals(1, features.size());
        Assertions.assertEquals("X", features.get(0).getName());
    }

    @Test
    public void shouldReturnFeatureXWhenGivenIncompatibleFeatureX() {
        List<FeatureEntity> features = featureRepository.getIncompatibleFeaturesByVin("incompatibleFeatureX");
        Assertions.assertEquals(1, features.size());
        Assertions.assertEquals("X", features.get(0).getName());
    }

    @Test
    public void shouldReturnFeatureYAndZWhenGivenCompatibleFeatureYAndZ() {
        FeatureEntity YFeature = new FeatureEntity();
        FeatureEntity ZFeature = new FeatureEntity();
        YFeature.setName("Y");
        ZFeature.setName("Z");

        List<FeatureEntity> features = featureRepository.getInstallableFeaturesByVin("compatibleFeatureYAndZ");
        Assertions.assertEquals(2, features.size());
        Assertions.assertTrue(features.contains(YFeature));
        Assertions.assertTrue(features.contains(ZFeature));
    }

    @Test
    public void shouldReturnFeatureZWhenGivenCompatibleFeatureYIncompatibleZ() {
        List<FeatureEntity> features = featureRepository.getIncompatibleFeaturesByVin("compatibleFeatureYIncompatibleZ");
        Assertions.assertEquals(1, features.size());
        Assertions.assertEquals("Z", features.get(0).getName());
    }

    @Test
    public void shouldReturnFeatureYWhenGivenCompatibleFeatureYIncompatibleZ() {
        List<FeatureEntity> features = featureRepository.getInstallableFeaturesByVin("compatibleFeatureYIncompatibleZ");
        Assertions.assertEquals(1, features.size());
        Assertions.assertEquals("Y", features.get(0).getName());
    }
}