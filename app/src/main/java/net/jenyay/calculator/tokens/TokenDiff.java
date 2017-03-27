package net.jenyay.calculator.tokens;

import net.jenyay.calculator.FormatException;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenDiff extends TokenOperator {
    public TokenDiff() {
        super("-", 1);
    }

    @Override
    public double call(Stack<Double> stack) throws FormatException {
        try {
            double y = stack.pop();
            double x = stack.pop();
            return x - y;
        }
        catch (EmptyStackException e) {
            throw new FormatException("Invalid equation");
        }
    }
}
