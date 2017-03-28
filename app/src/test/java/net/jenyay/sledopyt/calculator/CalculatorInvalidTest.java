package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.Calculator;
import net.jenyay.calculator.exceptions.FormatException;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by jenyay on 28.03.17.
 */

public class CalculatorInvalidTest {
    @Test(expected = FormatException.class)
    public void invalid_01() throws FormatException {
        String equation = "()";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_02() throws FormatException {
        String equation = "1+";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_03() throws FormatException {
        String equation = "1+2)";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_04() throws FormatException {
        String equation = "1+2(";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_05() throws FormatException {
        String equation = "(1+2";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_06() throws FormatException {
        String equation = "(1+2))";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_07() throws FormatException {
        String equation = "1++2";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_08() throws FormatException {
        String equation = "1+/2";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_09() throws FormatException {
        String equation = "1+2 5";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }

    @Test(expected = FormatException.class)
    public void invalid_10() throws FormatException {
        String equation = "((1+2)";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        calc.calculate(equation);
    }
}
