package net.jenyay.calculator.tokens;

/**
 * Created by jenyay on 26.03.17.
 */

public abstract class Token {
    private String _value;

    public String get_value() {
        return _value;
    }

    public Token(String value){
        _value = value;
    }
}
