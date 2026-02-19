package com.bernhard.unit_converter.service;

import com.bernhard.unit_converter.unit.LengthUnit;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LengthConversionService {

    public double convertLengthUnitFromTo(Double numberToConvert, String fromUnit, String toUnit) {
        LengthUnit from = LengthUnit.valueOf(fromUnit.toUpperCase(Locale.ROOT));
        LengthUnit to = LengthUnit.valueOf(toUnit.toUpperCase(Locale.ROOT));

        double unitInMeters = numberToConvert * from.factor;
        return unitInMeters / to.factor;
    }
}
