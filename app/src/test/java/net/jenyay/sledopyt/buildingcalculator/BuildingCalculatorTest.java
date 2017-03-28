package net.jenyay.sledopyt.buildingcalculator;

import net.jenyay.buildingcalculator.BuildingCalculator;
import net.jenyay.calculator.exceptions.CalculatorException;
import net.jenyay.calculator.exceptions.FormatException;
import net.jenyay.calculator.exceptions.UnknownVariableException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by jenyay on 28.03.17.
 */

public class BuildingCalculatorTest {
    @Test
    public void letters_01() throws CalculatorException {
        String streetName = "";
        String equation = "а";
        double expected = 1.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void letters_02() throws CalculatorException {
        String streetName = "";
        String equation = "я";
        double expected = 33.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void letters_03() throws CalculatorException {
        String streetName = "";
        String equation = "ё";
        double expected = 7.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void letters_04() throws CalculatorException {
        String streetName = "";
        String equation = "ы";
        double expected = 29.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void letters_05() throws CalculatorException {
        String streetName = "";
        String equation = "Ё";
        double expected = 7.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void letters_06() throws CalculatorException {
        String streetName = "";
        String equation = "а - б + в * 2";
        double expected = 5.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void street_01() throws CalculatorException {
        String streetName = "Крылатская";
        String equation = "x1";
        double expected = 12.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void street_02() throws CalculatorException {
        String streetName = "крылатская";
        String equation = "x1";
        double expected = 12.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void street_03() throws CalculatorException {
        String streetName = "Крылатская";
        String equation = "X1";
        double expected = 12.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void street_04() throws CalculatorException {
        String streetName = "Крылатская";
        String equation = "X1 + x5 - x10";
        double expected = -20.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void street_05() throws CalculatorException {
        String streetName = "Крылатская";
        String equation = "X1 + x5 - x10 + 10";
        double expected = -10.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test
    public void street_06() throws CalculatorException {
        String streetName = "а б в    г";
        String equation = "x1 + x2 * x4";
        double expected = 9.0;

        BuildingCalculator calc = new BuildingCalculator();
        double result = calc.calculate(equation, streetName);
        assertEquals(expected, result, 1e-7);
    }

    @Test(expected = FormatException.class)
    public void invalid_format_01() throws CalculatorException {
        String streetName = "";
        String equation = "5+6-";

        BuildingCalculator calc = new BuildingCalculator();
        calc.calculate(equation, streetName);
    }

    @Test(expected = FormatException.class)
    public void invalid_format_02() throws CalculatorException {
        String streetName = "";
        String equation = "а + б - в)";

        BuildingCalculator calc = new BuildingCalculator();
        calc.calculate(equation, streetName);
    }

    @Test(expected = UnknownVariableException.class)
    public void invalid_format_03() throws CalculatorException {
        String streetName = "";
        String equation = "x1 + 2";

        BuildingCalculator calc = new BuildingCalculator();
        calc.calculate(equation, streetName);
    }

    @Test(expected = UnknownVariableException.class)
    public void invalid_format_04() throws CalculatorException {
        String streetName = "Крылатская";
        String equation = "x0 + x1";

        BuildingCalculator calc = new BuildingCalculator();
        calc.calculate(equation, streetName);
    }

    @Test(expected = UnknownVariableException.class)
    public void invalid_format_05() throws CalculatorException {
        String streetName = "Крылатская";
        String equation = "x1 + x20";

        BuildingCalculator calc = new BuildingCalculator();
        calc.calculate(equation, streetName);
    }
}
