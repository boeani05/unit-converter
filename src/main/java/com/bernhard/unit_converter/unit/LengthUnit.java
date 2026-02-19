package com.bernhard.unit_converter.unit;

public enum LengthUnit {
    MM(0.001),
    CM(0.01),
    M(1),
    KM(1000),
    IN(0.0254),
    FT(0.3048),
    YD(0.9144),
    MI(1609.344);

    public final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }
}
