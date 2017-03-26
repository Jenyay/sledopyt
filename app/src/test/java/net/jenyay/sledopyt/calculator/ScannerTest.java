package net.jenyay.sledopyt.calculator;

import net.jenyay.calculator.FormatException;
import net.jenyay.calculator.Scanner;
import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenRealNumber;

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

    @Test(expected = FormatException.class)
    public void invalid_01() throws FormatException {
        String text = ".";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);
    }

    @Test(expected = FormatException.class)
    public void invalid_02() throws FormatException {
        String text = "#125";

        Scanner scanner = new Scanner();
        List<Token> result = scanner.parse(text);
    }
}
