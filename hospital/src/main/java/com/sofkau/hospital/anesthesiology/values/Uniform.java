package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Uniform implements ValueObject<String> {

    private final String value;

    public Uniform(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The uniform can not be empty");
        }
    }

    @Override
    public String value() {
        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uniform uniform = (Uniform) o;
        return value.equals(uniform.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
