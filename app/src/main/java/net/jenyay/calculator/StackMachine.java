package net.jenyay.calculator;

import net.jenyay.calculator.exceptions.CalculatorException;
import net.jenyay.calculator.exceptions.FormatException;
import net.jenyay.calculator.exceptions.UnknownVariableException;
import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenOperator;
import net.jenyay.calculator.tokens.TokenRealNumber;
import net.jenyay.calculator.tokens.TokenVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by jenyay on 20.01.17.
 */

class StackMachine {
    private HashMap<String, Double> _variables;

    StackMachine(HashMap<String, Double> variables) {
        _variables = (HashMap<String, Double>)variables.clone();
    }

    double execute(ArrayList<Token> reverseNotation)
            throws CalculatorException {
        Stack<Double> stack = new Stack<>();

        for(Token t : reverseNotation) {
            if (t instanceof TokenRealNumber) {
                stack.push(((TokenRealNumber)t).getDoubleValue());
            }
            else if (t instanceof TokenVariable) {
                TokenVariable tokenVar = (TokenVariable)t;
                Double value = _variables.get(tokenVar.get_value().toLowerCase());
                if (value == null) {
                    throw new UnknownVariableException(tokenVar.get_value());
                }
                stack.push(value);
            }
            else if (t instanceof TokenOperator) {
                TokenOperator op = (TokenOperator)t;
                double opResult = op.call(stack);
                stack.push(opResult);
            }
            else {
                throw new FormatException("Unknown token");
            }
        }

        if (stack.size() != 1) {
            throw new FormatException("Invalid equation");
        }

        return stack.pop();
    }
}
