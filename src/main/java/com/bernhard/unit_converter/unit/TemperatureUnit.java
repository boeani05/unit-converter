package com.bernhard.unit_converter.unit;

public enum TemperatureUnit {
    C(1, 273.15),
    K(1, 0),
    F(5.0 / 9.0, 255.37222222);

    public final double factor;
    public final double offsetToKelvin;

    TemperatureUnit(double factor, double offsetToKelvin) {
        this.factor = factor;
        this.offsetToKelvin = offsetToKelvin;
    }
}
