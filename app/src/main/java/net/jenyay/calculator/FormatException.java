package net.jenyay.calculator;

/**
 * Created by jenyay on 18.01.17.
 */

public class FormatException extends Exception {
    private String _strError;

    public FormatException(String error) {
        _strError = error;
    }
}
