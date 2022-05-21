package com.sofkau.hospital.domain.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TypeOfAnesthesia implements ValueObject<String> {
    private final String value;

    public TypeOfAnesthesia(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The type of anesthesia can not  can not be empty");
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
        TypeOfAnesthesia typeOfAnesthesia = (TypeOfAnesthesia) o;
        return value.equals(typeOfAnesthesia.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
