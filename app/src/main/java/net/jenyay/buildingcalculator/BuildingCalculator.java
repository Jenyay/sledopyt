package net.jenyay.buildingcalculator;

import net.jenyay.calculator.Calculator;
import net.jenyay.calculator.exceptions.CalculatorException;

import java.util.HashMap;

/**
 * Created by jenyay on 28.03.17.
 */

public class BuildingCalculator {
    private HashMap<String, Double> _letters;

    public BuildingCalculator() {
        _letters = new HashMap<>();
        for (char c = 'а'; c <= 'е'; c++) {
            _letters.put(Character.toString(c), (double)(c - 'а' + 1));
        }

        _letters.put("ё", 7.0);

        for (char c = 'ж'; c <= 'я'; c++) {
            _letters.put(Character.toString(c), (double)(c - 'ж' + 8));
        }
    }

    public double calculate(String equation, String streetName) throws CalculatorException {
        streetName = streetName.replace(" ", "");
        streetName = streetName.toLowerCase();

        HashMap<String, Double> lettersPositions = new HashMap<>();
        for (int i = 0; i < streetName.length(); i++) {
            String varName = "x" + Integer.toString(i + 1);
            String character = streetName.substring(i, i + 1);
            Double value = _letters.get(character);

            lettersPositions.put(varName, value);
        }

        HashMap<String, Double> variables = new HashMap<>();
        variables.putAll(_letters);
        variables.putAll(lettersPositions);

        Calculator calc = new Calculator(variables);
        return calc.calculate(equation.toLowerCase());
    }
}
