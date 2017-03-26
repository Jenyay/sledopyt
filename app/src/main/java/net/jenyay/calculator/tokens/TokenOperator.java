package net.jenyay.calculator.tokens;

/**
 * Created by jenyay on 26.03.17.
 */

public abstract class TokenOperator extends Token {
    private int _priority;

    public int get_priority() { return _priority; }

    public TokenOperator(String value, int priority) {
        super(value);
        _priority = priority;
    }
}
