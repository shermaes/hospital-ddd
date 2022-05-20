package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Storage implements ValueObject<Integer> {

    private final Integer value;

    public Storage(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value == 0) {
            throw new IllegalArgumentException("The storage can not be empty");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return value.equals(storage.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
