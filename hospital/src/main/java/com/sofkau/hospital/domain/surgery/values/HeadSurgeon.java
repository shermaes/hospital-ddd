package com.sofkau.hospital.domain.surgery.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HeadSurgeon implements ValueObject<String> {
    private final String value;

    public HeadSurgeon(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The Head Surgeon can not be empty");
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
        HeadSurgeon headSurgeon = (HeadSurgeon) o;
        return value.equals(headSurgeon.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
