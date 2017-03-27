package net.jenyay.calculator.tokens;

import net.jenyay.calculator.FormatException;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenUnaryMinus extends TokenOperator {
    public TokenUnaryMinus() {
        super("-", 1);
    }

    @Override
    public double call(Stack<Double> stack) throws FormatException {
        try {
            double x = stack.pop();
            return -x;
        }
        catch (EmptyStackException e) {
            throw new FormatException("Invalid equation");
        }
    }
}

