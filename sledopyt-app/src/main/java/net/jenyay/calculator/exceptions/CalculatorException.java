package net.jenyay.calculator.exceptions;

/**
 * Created by jenyay on 27.03.17.
 */

public class CalculatorException extends Exception {
    private String _strError;

    public String getText() {
        return _strError;
    }

    public CalculatorException(String error) {
        _strError = error;
    }

    public String toString() {
        return "(CalculatorException) " + getText();
    }
}
