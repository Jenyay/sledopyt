package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.FormatException;
import net.jenyay.calculator.Scanner;
import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenBracketLeft;
import net.jenyay.calculator.tokens.TokenBracketRight;
import net.jenyay.calculator.tokens.TokenDiff;
import net.jenyay.calculator.tokens.TokenDiv;
import net.jenyay.calculator.tokens.TokenProd;
import net.jenyay.calculator.tokens.TokenRealNumber;
import net.jenyay.calculator.tokens.TokenSum;
import net.jenyay.calculator.tokens.TokenUnaryMinus;
import net.jenyay.calculator.tokens.TokenUnaryPlus;
import net.jenyay.calculator.tokens.TokenVariable;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jenyay on 26.03.17.
 */

public class ScannerTest {
    @Test
    public void emptyString() throws FormatException {
        String text = "";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.isEmpty());
    }

    @Test
    public void spaces() throws FormatException {
        String text = "    ";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.isEmpty());
    }

    @Test(expected = FormatException.class)
    public void invalid_01() throws FormatException {
        String text = ".";

        Scanner scanner = new Scanner();
        scanner.parse(text);
    }

    @Test(expected = FormatException.class)
    public void invalid_02() throws FormatException {
        String text = "#125";

        Scanner scanner = new Scanner();
        scanner.parse(text);
    }

    @Test
    public void real_01() throws FormatException {
        String text = "0";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertEquals(((TokenRealNumber)result.get(0)).getDoubleValue(), 0.0, 1e-7);
    }

    @Test
    public void real_02() throws FormatException {
        String text = "123";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertEquals(((TokenRealNumber)result.get(0)).getDoubleValue(), 123.0, 1e-7);
    }

    @Test
    public void real_03() throws FormatException {
        String text = "123.456";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertEquals(((TokenRealNumber)result.get(0)).getDoubleValue(), 123.456, 1e-7);
    }

    @Test
    public void real_04() throws FormatException {
        String text = ".456";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertEquals(((TokenRealNumber)result.get(0)).getDoubleValue(), 0.456, 1e-7);
    }

    @Test
    public void real_05() throws FormatException {
        String text = "123.";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertEquals(((TokenRealNumber)result.get(0)).getDoubleValue(), 123.0, 1e-7);
    }

    @Test
    public void variable_01() throws FormatException {
        String text = "x";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenVariable);
    }

    @Test
    public void variable_02() throws FormatException {
        String text = "__абырвалг__";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenVariable);
    }


    @Test
    public void variable_03() throws FormatException {
        String text = "АБЫРВАЛГ";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenVariable);
    }

    @Test
    public void variable_04() throws FormatException {
        String text = "x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenVariable);
    }

    @Test
    public void variable_05() throws FormatException {
        String text = "_x5_";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenVariable);
    }

    @Test
    public void variable_06() throws FormatException {
        String text = "  xxx  ";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenVariable);
    }

    @Test
    public void sum_01() throws FormatException {
        String text = "1 + 2";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenSum);
        assertTrue(result.get(2) instanceof TokenRealNumber);
    }

    @Test
    public void sum_02() throws FormatException {
        String text = "1 + x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenSum);
        assertTrue(result.get(2) instanceof TokenVariable);
    }

    @Test
    public void diff_01() throws FormatException {
        String text = "1 - 2";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenDiff);
        assertTrue(result.get(2) instanceof TokenRealNumber);
    }

    @Test
    public void diff_02() throws FormatException {
        String text = "1 - x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenDiff);
        assertTrue(result.get(2) instanceof TokenVariable);
    }

    @Test
    public void prod_01() throws FormatException {
        String text = "1 * 2";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenProd);
        assertTrue(result.get(2) instanceof TokenRealNumber);
    }

    @Test
    public void prod_02() throws FormatException {
        String text = "1 * x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenProd);
        assertTrue(result.get(2) instanceof TokenVariable);
    }

    @Test
    public void div_01() throws FormatException {
        String text = "1 / 2";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenDiv);
        assertTrue(result.get(2) instanceof TokenRealNumber);
    }

    @Test
    public void div_02() throws FormatException {
        String text = "1 / x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenDiv);
        assertTrue(result.get(2) instanceof TokenVariable);
    }

    @Test
    public void bracket_01() throws FormatException {
        String text = "()";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenBracketLeft);
        assertTrue(result.get(1) instanceof TokenBracketRight);
    }

    @Test
    public void bracket_02() throws FormatException {
        String text = "(1 - x5)";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenBracketLeft);
        assertTrue(result.get(1) instanceof TokenRealNumber);
        assertTrue(result.get(2) instanceof TokenDiff);
        assertTrue(result.get(3) instanceof TokenVariable);
        assertTrue(result.get(4) instanceof TokenBracketRight);
    }

    @Test
    public void unary_minus_01() throws FormatException {
        String text = "-1";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenUnaryMinus);
        assertTrue(result.get(1) instanceof TokenRealNumber);
    }

    @Test
    public void unary_minus_02() throws FormatException {
        String text = "-x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenUnaryMinus);
        assertTrue(result.get(1) instanceof TokenVariable);
    }

    @Test
    public void unary_minus_03() throws FormatException {
        String text = "(-x5)";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenBracketLeft);
        assertTrue(result.get(1) instanceof TokenUnaryMinus);
        assertTrue(result.get(2) instanceof TokenVariable);
        assertTrue(result.get(3) instanceof TokenBracketRight);
    }

    @Test
    public void unary_minus_04() throws FormatException {
        String text = "1 - (-5)";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenDiff);
        assertTrue(result.get(2) instanceof TokenBracketLeft);
        assertTrue(result.get(3) instanceof TokenUnaryMinus);
        assertTrue(result.get(4) instanceof TokenRealNumber);
        assertTrue(result.get(5) instanceof TokenBracketRight);
    }

    @Test
    public void unary_plus_01() throws FormatException {
        String text = "+1";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenUnaryPlus);
        assertTrue(result.get(1) instanceof TokenRealNumber);
    }

    @Test
    public void unary_plus_02() throws FormatException {
        String text = "+x5";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenUnaryPlus);
        assertTrue(result.get(1) instanceof TokenVariable);
    }

    @Test
    public void unary_plus_03() throws FormatException {
        String text = "(+x5)";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenBracketLeft);
        assertTrue(result.get(1) instanceof TokenUnaryPlus);
        assertTrue(result.get(2) instanceof TokenVariable);
        assertTrue(result.get(3) instanceof TokenBracketRight);
    }

    @Test
    public void unary_plus_04() throws FormatException {
        String text = "1 - (+5)";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);

        assertTrue(result.get(0) instanceof TokenRealNumber);
        assertTrue(result.get(1) instanceof TokenDiff);
        assertTrue(result.get(2) instanceof TokenBracketLeft);
        assertTrue(result.get(3) instanceof TokenUnaryPlus);
        assertTrue(result.get(4) instanceof TokenRealNumber);
        assertTrue(result.get(5) instanceof TokenBracketRight);
    }
}
