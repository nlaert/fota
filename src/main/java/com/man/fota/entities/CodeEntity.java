package com.man.fota.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "codes")
public class CodeEntity {

    @Id
    private String code;
    private String isHardware;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsHardware() {
        return isHardware;
    }

    public void setIsHardware(String isHardware) {
        this.isHardware = isHardware;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeEntity that = (CodeEntity) o;
        return Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getIsHardware(), that.getIsHardware());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getIsHardware());
    }
}
