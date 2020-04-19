package com.man.fota.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FeatureCodeKey implements Serializable {

    @JoinColumn(name = "feature_name")
    @ManyToOne
    private FeatureEntity featureName;

    @JoinColumn(name = "code")
    @ManyToOne
    private CodeEntity code;

    public FeatureEntity getFeatureName() {
        return featureName;
    }

    public void setFeatureName(final FeatureEntity featureName) {
        this.featureName = featureName;
    }

    public CodeEntity getCode() {
        return code;
    }

    public void setCode(final CodeEntity code) {
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
