package com.sofkau.hospital.surgery.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class OperatingRoom implements ValueObject<String> {

    private final String value;

    public OperatingRoom(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The Operating Room can not be empty");
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
        OperatingRoom operatingRoom = (OperatingRoom) o;
        return value.equals(operatingRoom.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
