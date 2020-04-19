package com.man.fota.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "codes")
public class CodeEntity {

    @Id
    private String code;
    private boolean isHardware;

    protected CodeEntity() {
    }

    public CodeEntity(final String code, final boolean isHardware) {
        this.code = code;
        this.isHardware = isHardware;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isHardware() {
        return isHardware;
    }

    public void setHardware(final boolean hardware) {
        isHardware = hardware;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeEntity that = (CodeEntity) o;
        return isHardware() == that.isHardware() &&
                Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), isHardware());
    }
}
