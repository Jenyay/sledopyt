package net.jenyay.calculator;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenOperator;
import net.jenyay.calculator.tokens.TokenRealNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.EmptyStackException;

/**
 * Created by jenyay on 20.01.17.
 */

public class StackMachine {
    private HashMap<String, Double> _variables;

    public StackMachine(HashMap<String, Double> variables) {
        _variables = (HashMap<String, Double>)variables.clone();
    }

    public Double execute(ArrayList<Token> reverseNotation)
            throws FormatException {
        Stack<Double> stack = new Stack<>();

        for(Token t : reverseNotation) {
            if (t instanceof TokenRealNumber) {
                stack.push(((TokenRealNumber)t).getDoubleValue());
            }
            else {
                TokenOperator op = (TokenOperator)t;
                double opResult = op.call(stack);
                stack.push(opResult);
            }
        }

        if (stack.size() != 1) {
            throw new FormatException("Invalid equation");
        }

        return stack.pop();
    }
}
