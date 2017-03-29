package net.jenyay.calculator.exceptions;

/**
 * Created by jenyay on 18.01.17.
 */

public class FormatException extends CalculatorException {
    public FormatException(String error) {
        super(error);
    }

    public String toString() {
        return "(FormatException) " + getText();
    }
}
