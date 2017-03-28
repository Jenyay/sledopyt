package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.Calculator;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by jenyay on 28.03.17.
 */

public class CalculatorVariablesTest {
    @Test
    public void calc_var_01() throws Exception {
        String equation = "X";
        Double result_expected = 11.0;

        HashMap<String, Double> variables = new HashMap<>();
        variables.put("x", 11.0);

        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_var_02() throws Exception {
        String equation = "x";
        Double result_expected = 11.0;

        HashMap<String, Double> variables = new HashMap<>();
        variables.put("x", 11.0);

        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_var_03() throws Exception {
        String equation = "x1 + y2 - а";
        Double result_expected = 16.0;

        HashMap<String, Double> variables = new HashMap<>();
        variables.put("а", 1.0);
        variables.put("x1", 2.0);
        variables.put("y2", 15.0);

        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }
}
