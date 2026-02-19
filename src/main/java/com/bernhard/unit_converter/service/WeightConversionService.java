package com.bernhard.unit_converter.service;

import com.bernhard.unit_converter.unit.WeightUnit;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class WeightConversionService {
    public double convertWeightUnitFromTo(Double numberToConvert, String fromUnit, String toUnit) {
        WeightUnit from = WeightUnit.valueOf(fromUnit.toUpperCase(Locale.ROOT));
        WeightUnit to = WeightUnit.valueOf(toUnit.toUpperCase(Locale.ROOT));

        double unitInG = numberToConvert * from.factor;
        return unitInG / to.factor;
    }
}
