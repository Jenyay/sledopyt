package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.Calculator;
import net.jenyay.calculator.tokens.Token;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by jenyay on 28.03.17.
 */

public class NotationTest {
    @Test
    public void notation_empty() throws Exception {
        String equation = "";
        String result_expected = "";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_digit_01() throws Exception {
        String equation = "0";
        String result_expected = "0";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_digit_02() throws Exception {
        String equation = "103";
        String result_expected = "103";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_variables_01() throws Exception {
        String equation = "x";
        String result_expected = "x";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_variables_02() throws Exception {
        String equation = "x10";
        String result_expected = "x10";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_sum_01() throws Exception {
        String equation = "1+2";
        String result_expected = "1 2 +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_sum_02() throws Exception {
        String equation = "101 + 205";
        String result_expected = "101 205 +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_sum_03() throws Exception {
        String equation = "(101 + 205)";
        String result_expected = "101 205 +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_sum_04() throws Exception {
        String equation = "((101 + 205))";
        String result_expected = "101 205 +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_mult_01() throws Exception {
        String equation = "101*205";
        String result_expected = "101 205 *";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_mult_02() throws Exception {
        String equation = "101 * 205";
        String result_expected = "101 205 *";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_mult_03() throws Exception {
        String equation = "(101 * 205)";
        String result_expected = "101 205 *";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_mult_04() throws Exception {
        String equation = "((101 * 205))";
        String result_expected = "101 205 *";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_diff_01() throws Exception {
        String equation = "101 - 205";
        String result_expected = "101 205 -";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_diff_02() throws Exception {
        String equation = "(101 - 205)";
        String result_expected = "101 205 -";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_diff_03() throws Exception {
        String equation = "((101 - 205))";
        String result_expected = "101 205 -";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_braces_01() throws Exception {
        String equation = "(101) - (205)";
        String result_expected = "101 205 -";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_braces_02() throws Exception {
        String equation = "(101 - (205))";
        String result_expected = "101 205 -";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_div_01() throws Exception {
        String equation = "101 / 205";
        String result_expected = "101 205 /";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_div_02() throws Exception {
        String equation = "(101 / 205)";
        String result_expected = "101 205 /";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
        assertEquals(3, notation.size());
    }

    @Test
    public void notation_complex_01() throws Exception {
        String equation = "(A+B)*(C+D)-E";
        String result_expected = "A B + C D + * E -";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_complex_02() throws Exception {
        String equation = "20 + 30 * 40";
        String result_expected = "20 30 40 * +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_complex_03() throws Exception {
        String equation = "X + Y + Z";
        String result_expected = "X Y + Z +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }

    @Test
    public void notation_complex_04() throws Exception {
        String equation = "3 + 4 * 2 / (1 - 5)^2";
        String result_expected = "3 4 2 * 1 5 - 2 ^ / +";

        HashMap<String, Double> variables = new HashMap<>();
        Calculator calc = new Calculator(variables);
        ArrayList<Token> notation = calc.buildReversePolishNotation(equation);
        String result = notationToString(notation);

        assertEquals(result_expected, result);
    }


    private String notationToString(ArrayList<Token> notation) {
        String result = "";
        for (int i = 0; i < notation.size(); i++) {
            if (i != 0) {
                result += " ";
            }
            result += notation.get(i).get_value();
        }

        return result;
    }
}
