package com.bernhard.unit_converter.service;

import com.bernhard.unit_converter.unit.TemperatureUnit;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TemperatureConversionService {

    public double convertTemperatureFromTo(Double numberToConvert, String fromUnit, String toUnit) {
        TemperatureUnit from = TemperatureUnit.valueOf(fromUnit.toUpperCase(Locale.ROOT));
        TemperatureUnit to = TemperatureUnit.valueOf(toUnit.toUpperCase(Locale.ROOT));

        double unitInK = numberToConvert * from.factor + from.offsetToKelvin;
        return (unitInK - to.offsetToKelvin) / to.factor;
    }
}
