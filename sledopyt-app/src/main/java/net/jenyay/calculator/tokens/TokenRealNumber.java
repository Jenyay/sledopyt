package net.jenyay.calculator.tokens;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenRealNumber extends Token {
    private double _doubleValue;

    public double getDoubleValue() { return _doubleValue; }

    public  TokenRealNumber(String value) {
        super(value);
        _doubleValue = Double.parseDouble(value);
    }
}
