package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Brand implements ValueObject<String> {

    private final String value;

    public Brand(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The brand name can not be empty");
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
        Brand brand = (Brand) o;
        return value.equals(brand.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
