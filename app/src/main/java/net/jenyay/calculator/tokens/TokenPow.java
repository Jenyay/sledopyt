package net.jenyay.calculator.tokens;

import net.jenyay.calculator.FormatException;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by jenyay on 27.03.17.
 */

public class TokenPow extends TokenOperator {
    public TokenPow(String operator) {
        super(operator, 3);
    }

    @Override
    public double call(Stack<Double> stack) throws FormatException {
        try {
            double y = stack.pop();
            double x = stack.pop();
            return Math.pow(x, y);
        }
        catch (EmptyStackException e) {
            throw new FormatException("Invalid equation");
        }
    }
}
