package net.jenyay.calculator.tokens;

import net.jenyay.calculator.exceptions.FormatException;

import java.util.Stack;

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

    public abstract  double call(Stack<Double> stack) throws FormatException;
}
