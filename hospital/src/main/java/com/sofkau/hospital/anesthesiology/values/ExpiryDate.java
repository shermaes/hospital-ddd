package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ExpiryDate implements ValueObject<String> {

    private final String value;

    public ExpiryDate(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()) {
            throw new IllegalArgumentException("The expiry date can not be empty");
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
        ExpiryDate expiryDate = (ExpiryDate) o;
        return value.equals(expiryDate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
