package net.jenyay.calculator.tokens;

import net.jenyay.calculator.exceptions.FormatException;

import java.util.Stack;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenBracketLeft extends TokenOperator {
    public TokenBracketLeft() {
        super("(", 0);
    }

    @Override
    public double call(Stack<Double> stack) throws FormatException {
        throw new FormatException("Invalid operator call");
    }
}
