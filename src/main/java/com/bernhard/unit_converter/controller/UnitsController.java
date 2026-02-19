package com.bernhard.unit_converter.controller;

import com.bernhard.unit_converter.service.LengthConversionService;
import com.bernhard.unit_converter.service.TemperatureConversionService;
import com.bernhard.unit_converter.service.WeightConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitsController {

    @Autowired
    private LengthConversionService lengthConversionService;

    @Autowired
    private WeightConversionService weightConversionService;

    @Autowired
    private TemperatureConversionService temperatureConversionService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/length")
    public String lengthConverter(Model model) {
        model.addAttribute("page", "length");
        return "length";
    }

    @GetMapping("/weight")
    public String weightConverter(Model model) {
        model.addAttribute("page", "weight");
        return "weight";
    }

    @GetMapping("/temperature")
    public String temperatureConverter(Model model) {
        model.addAttribute("page", "temperature");
        return "temperature";
    }

    @PostMapping("/length")
    public String convertLength(
            @RequestParam(required = false) Double lengthToConvert,
            @RequestParam String fromUnit,
            @RequestParam String toUnit,
            @RequestParam Integer precisionNumbers,
            Model model
    ) {
        if (!isNumberToConvertValid(lengthToConvert)) {
            return "redirect:/length?error=invalidNumberToConvert";
        }

        if (doesFromUnitEqualToUnit(fromUnit, toUnit)) {
            return "redirect:/length?error=toSameUnit";
        }

        double convertedResultUnrounded = lengthConversionService.convertLengthUnitFromTo(lengthToConvert, fromUnit, toUnit);

        double convertedResultRounded = Math.round(convertedResultUnrounded * Math.pow(10, precisionNumbers)) / Math.pow(10, precisionNumbers);

        Object processedResult;

        if (convertedResultRounded % 1 == 0) {
            processedResult = (long) convertedResultRounded;
        } else {
            processedResult = convertedResultRounded;
        }

        model.addAttribute("processedResult", processedResult);
        model.addAttribute("fromUnit", fromUnit);
        model.addAttribute("toUnit", toUnit);
        model.addAttribute("lengthToConvert", lengthToConvert);

        return "length";
    }

    @PostMapping("/weight")
    public String convertWeight(
            @RequestParam(required = false) Double weightToConvert,
            @RequestParam String fromUnit,
            @RequestParam String toUnit,
            @RequestParam Integer precisionNumbers,
            Model model
    ) {

        if (!isNumberToConvertValid(weightToConvert)) {
            return "redirect:/weight?error=invalidNumberToConvert";
        }

        if (doesFromUnitEqualToUnit(fromUnit, toUnit)) {
            return "redirect:/weight?error=toSameUnit";
        }

        double convertedResultUnrounded = weightConversionService.convertWeightUnitFromTo(weightToConvert, fromUnit, toUnit);

        double convertedResultRounded = Math.round(convertedResultUnrounded * Math.pow(10, precisionNumbers)) / Math.pow(10, precisionNumbers);

        Object processedResult;

        if (convertedResultRounded % 1 == 0) {
            processedResult = (long) convertedResultRounded;
        } else {
            processedResult = convertedResultRounded;
        }

        model.addAttribute("processedResult", processedResult);
        model.addAttribute("fromUnit", fromUnit);
        model.addAttribute("toUnit", toUnit);
        model.addAttribute("weightToConvert", weightToConvert);

        return "weight";
    }

    @PostMapping("/temperature")
    public String convertTemperature(
            @RequestParam(required = false) Double temperatureToConvert,
            @RequestParam String fromUnit,
            @RequestParam String toUnit,
            @RequestParam Integer precisionNumbers,
            Model model
    ) {

        if (!isNumberToConvertValid(temperatureToConvert)) {
            return "redirect:/temperature?error=invalidNumberToConvert";
        }

        if (doesFromUnitEqualToUnit(fromUnit, toUnit)) {
            return "redirect:/temperature?error=toSameUnit";
        }

        double convertedResultUnrounded = temperatureConversionService.convertTemperatureFromTo(temperatureToConvert, fromUnit, toUnit);

        double convertedResultRounded = Math.round(convertedResultUnrounded * Math.pow(10, precisionNumbers)) / Math.pow(10, precisionNumbers);

        Object processedResult;

        if (convertedResultRounded % 1 == 0) {
            processedResult = (long) convertedResultRounded;
        } else {
            processedResult = convertedResultRounded;
        }

        model.addAttribute("processedResult", processedResult);
        model.addAttribute("fromUnit", fromUnit);
        model.addAttribute("toUnit", toUnit.toUpperCase());
        model.addAttribute("temperatureToConvert", temperatureToConvert);

        return "temperature";
    }

    private boolean isNumberToConvertValid(Double numberToConvert) {
        return !(numberToConvert == null || numberToConvert.isNaN());
    }

    private boolean doesFromUnitEqualToUnit(String fromUnit, String toUnit) {
        return fromUnit.equals(toUnit);
    }
}
