package com.man.fota.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "feature_codes")
public class FeatureCodesEntity {

    @EmbeddedId
    private FeatureCodeKey featureCodeKey;
    private boolean isRequired;

    public FeatureCodeKey getFeatureCodeKey() {
        return featureCodeKey;
    }

    public void setFeatureCodeKey(FeatureCodeKey featureCodeKey) {
        this.featureCodeKey = featureCodeKey;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureCodesEntity that = (FeatureCodesEntity) o;
        return isRequired() == that.isRequired() &&
                Objects.equals(getFeatureCodeKey(), that.getFeatureCodeKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeatureCodeKey(), isRequired());
    }
}
