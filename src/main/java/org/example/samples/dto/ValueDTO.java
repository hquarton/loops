package org.example.samples.dto;

import java.io.Serializable;

public class ValueDTO implements Serializable {

    private String name;
    private String value;
    private String validite;
    private String source;

    private Boolean normal;

    private Boolean corrected;

    public String getName() {
        return name;
    }

    public ValueDTO setName(String horodate) {
        this.name = horodate;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ValueDTO setValue(String value) {
        this.value = value;
        return this;
    }

    public String getValidite() {
        return validite;
    }

    public ValueDTO setValidite(String validite) {
        this.validite = validite;
        return this;
    }

    public String getSource() {
        return source;
    }

    public ValueDTO setSource(String source) {
        this.source = source;
        return this;
    }
    public Boolean getNormal() {
        return normal;
    }

    public ValueDTO setNormal(Boolean normal) {
        this.normal = normal;
        return this;
    }

    public Boolean getCorrected() {
        return corrected;
    }

    public ValueDTO setCorrected(Boolean corrected) {
        this.corrected = corrected;
        return this;
    }
}
