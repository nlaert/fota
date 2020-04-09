package com.man.fota.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FeatureCodeKey implements Serializable {
    private String featureName;
    private String code;

    //TODO: ctor might be necessary
    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureCodeKey that = (FeatureCodeKey) o;
        return Objects.equals(getFeatureName(), that.getFeatureName()) &&
                Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFeatureName(), getCode());
    }
}
