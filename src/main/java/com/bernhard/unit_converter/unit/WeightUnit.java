package com.bernhard.unit_converter.unit;

public enum WeightUnit {
    MG(0.001),
    G(1),
    KG(1000),
    T(1000000),
    OZ(0.035274),
    LB(0.00220462);

    public final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }
}
