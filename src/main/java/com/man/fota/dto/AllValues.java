package com.man.fota.dto;

import java.util.ArrayList;
import java.util.List;

public class AllValues<T> {
    private List<T> installable;
    private List<T> incompatible;

    public AllValues() {
        installable = new ArrayList<>();
        incompatible = new ArrayList<>();
    }

    public List<T> getInstallable() {
        return installable;
    }

    public void setInstallable(final List<T> installable) {
        this.installable = installable;
    }

    public List<T> getIncompatible() {
        return incompatible;
    }

    public void setIncompatible(final List<T> incompatible) {
        this.incompatible = incompatible;
    }

    public void addInstallable(T newValue) {
        installable.add(newValue);
    }

    public void addIncompatible(T newValue) {
        incompatible.add(newValue);
    }
}
