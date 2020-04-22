package com.man.fota.dto;

import java.util.Objects;

public class FeatureDto {
    private String featureName;

    public FeatureDto(final String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(final String featureName) {
        this.featureName = featureName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureDto that = (FeatureDto) o;
        return Objects.equals(getFeatureName(), that.getFeatureName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeatureName());
    }
}
