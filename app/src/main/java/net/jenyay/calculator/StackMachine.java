package net.jenyay.calculator;

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
            if (t.getType() == Token.Type.VALUE) {
                try {
                    Double val = Double.parseDouble(t.getValue());
                    stack.push(val);
                }
                catch (NumberFormatException e) {
                    throw new FormatException("Invalid value: " + t.getValue());
                }
            }
            else {
                execOpertor(t, stack);
            }
        }

        if (stack.size() != 1) {
            throw new FormatException("Invalid equation");
        }

        return stack.pop();
    }

    private Double execOpertor(Token t, Stack<Double> stack)
            throws FormatException {
        Double result;

        switch (t.getValue()) {
            case "+":
                result = sum(stack);
                stack.push(result);
                break;
            case "*":
                result = mul(stack);
                stack.push(result);
                break;
            default:
                throw new FormatException("Unknown operator: " + t.getValue());
        }

        return result;
    }

    private Double sum(Stack<Double> stack) throws FormatException {
        try {
            double y = stack.pop();
            double x = stack.pop();
            return x + y;
        }
        catch (EmptyStackException e) {
            throw new FormatException("Invalid equation");
        }
    }

    private Double mul(Stack<Double> stack) throws FormatException {
        try {
            double y = stack.pop();
            double x = stack.pop();
            return x * y;
        }
        catch (EmptyStackException e) {
            throw new FormatException("Invalid equation");
        }
    }
}
