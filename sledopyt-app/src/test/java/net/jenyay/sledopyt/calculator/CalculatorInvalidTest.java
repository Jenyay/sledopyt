package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.Calculator;
import net.jenyay.calculator.exceptions.CalculatorException;
import net.jenyay.calculator.exceptions.FormatException;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by jenyay on 28.03.17.
 */

public class CalculatorInvalidTest {
    @Test(expected = FormatException.class)
    public void invalid_01() throws CalculatorException {
        String equation = "()";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_02() throws CalculatorException {
        String equation = "1+";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_03() throws CalculatorException {
        String equation = "1+2)";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_04() throws CalculatorException {
        String equation = "1+2(";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_05() throws CalculatorException {
        String equation = "(1+2";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_06() throws CalculatorException {
        String equation = "(1+2))";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_07() throws CalculatorException {
        String equation = "1++2";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_08() throws CalculatorException {
        String equation = "1+/2";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_09() throws CalculatorException {
        String equation = "1+2 5";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_10() throws CalculatorException {
        String equation = "((1+2)";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_11() throws CalculatorException {
        String equation = ".";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_12() throws CalculatorException {
        String equation = ",";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_13() throws CalculatorException {
        String equation = "";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }
}
