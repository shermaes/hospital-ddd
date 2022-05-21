package com.sofkau.hospital.domain.surgery;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.hospital.domain.surgery.values.Area;
import com.sofkau.hospital.domain.surgery.values.HeadSurgeon;
import com.sofkau.hospital.domain.surgery.values.InstrumentalistID;

import java.util.Objects;

public class Instrumentalist extends Entity<InstrumentalistID> {
    private HeadSurgeon headSurgeon;
    private Area area;

    public Instrumentalist(InstrumentalistID entityId, HeadSurgeon headSurgeon, Area area) {
        super(entityId);
        this.headSurgeon = headSurgeon;
        this.area = area;
    }

    //getters

    public HeadSurgeon getHeadSurgeon() {
        return headSurgeon;
    }

    public Area getArea() {
        return area;
    }

    //behaviors
    public void changeHeadSurgeon(HeadSurgeon headSurgeon) {
        this.headSurgeon = Objects.requireNonNull(headSurgeon);
    }

    public void updateArea(Area area) {
        this.area = Objects.requireNonNull(area);
    }
}
