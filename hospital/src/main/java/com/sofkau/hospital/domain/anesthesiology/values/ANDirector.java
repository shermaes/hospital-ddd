package com.sofkau.hospital.domain.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ANDirector implements ValueObject<String> {

    private final String value;

    public ANDirector(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The director name can not be empty");
        }

    }

    @Override
    public String value() {
        return null;
    }

    //Creates and returns a copy of this object.
// The precise meaning of "copy" may depend on the class of the object.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ANDirector anDirector = (ANDirector) o;
        return value.equals(anDirector.value);
    }

    //Indicates whether some other object is "equal to" this one.
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
