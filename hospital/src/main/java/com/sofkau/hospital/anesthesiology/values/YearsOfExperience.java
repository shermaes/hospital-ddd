package com.sofkau.hospital.anesthesiology.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class YearsOfExperience  implements ValueObject<Integer> {

    private final Integer value;

    public YearsOfExperience(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value ==0) {
            throw new IllegalArgumentException("You need at least 1 year of experience");
        }
    }

    @Override
    public Integer value() {
        return null;
    }
//Creates and returns a copy of this object.
// The precise meaning of "copy" may depend on the class of the object.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearsOfExperience that = (YearsOfExperience) o;
        return Objects.equals(value, that.value);
    }

//Indicates whether some other object is "equal to" this one.
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
