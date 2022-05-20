package com.sofkau.hospital.surgery.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SurgeryRoom implements ValueObject<Integer> {

private final Integer value;

public SurgeryRoom(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value == 0) {
        throw new IllegalArgumentException("The Surgery Room can not be empty");
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
    SurgeryRoom surgeryRoom = (SurgeryRoom) o;
        return value.equals(surgeryRoom.value);
        }

@Override
public int hashCode() {
        return Objects.hash(value);
        }
}
