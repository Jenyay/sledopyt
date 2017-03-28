package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.Calculator;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalculatorTest {
    @Test
    public void calc_sum_01() throws Exception {
        String equation = "3 + 4";
        Double result_expected = 7.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_sum_02() throws Exception {
        String equation = "3 + 4 + 10";
        Double result_expected = 17.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_sum_03() throws Exception {
        String equation = "3 + (4 + 10)";
        Double result_expected = 17.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_sum_04() throws Exception {
        String equation = "(3 + 4) + 10";
        Double result_expected = 17.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_diff_01() throws Exception {
        String equation = "5 - 1";
        Double result_expected = 4.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_diff_02() throws Exception {
        String equation = "5 - 1 - 5";
        Double result_expected = -1.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_div_01() throws Exception {
        String equation = "6 / 2";
        Double result_expected = 3.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_div_02() throws Exception {
        String equation = "6 / 2 / 2";
        Double result_expected = 1.5;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_mul_01() throws Exception {
        String equation = "3 * 4";
        Double result_expected = 12.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_mul_02() throws Exception {
        String equation = "3 * 4 * 2";
        Double result_expected = 24.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_01() throws Exception {
        String equation = "3 + 4 * 2";
        Double result_expected = 11.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_02() throws Exception {
        String equation = "(3 + 4) * 2";
        Double result_expected = 14.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_03() throws Exception {
        String equation = "3 - 4 * 2";
        Double result_expected = -5.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_04() throws Exception {
        String equation = "3 - 4 / 2";
        Double result_expected = 1.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_05() throws Exception {
        String equation = "1 + 3 ^ 2";
        Double result_expected = 10.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_06() throws Exception {
        String equation = "1 + 3 ** 2";
        Double result_expected = 10.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_07() throws Exception {
        String equation = "-13 + 14 * 2 / (1 - 3)^2";
        Double result_expected = -6.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_full_08() throws Exception {
        String equation = "-13 + 14 * 2 / (1 - 3) ** 2";
        Double result_expected = -6.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_sign_01() throws Exception {
        String equation = "-2";
        Double result_expected = -2.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_sign_02() throws Exception {
        String equation = "(-3 + 4) * 2";
        Double result_expected = 2.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }

    @Test
    public void calc_sign_03() throws Exception {
        String equation = "(3 + 4) * (-2)";
        Double result_expected = -14.0;

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        Double result = calc.calculate(equation);

        assertEquals(result_expected, result);
    }
}