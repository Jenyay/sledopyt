package net.jenyay.calculator;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenBracketLeft;
import net.jenyay.calculator.tokens.TokenBracketRight;
import net.jenyay.calculator.tokens.TokenOperator;
import net.jenyay.calculator.tokens.TokenRealNumber;
import net.jenyay.calculator.tokens.TokenVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


/**
 * Created by jenyay on 17.01.17.
 */

public class Calculator {
    private HashMap<String, Double> _variables;

    public Calculator(HashMap<String, Double> variables) {
        _variables = variables;
    }

    public Double calculate(String equation) throws FormatException {
        ArrayList<Token> notation = buildReversePolishNotation(equation);
        StackMachine machine = new StackMachine(_variables);
        return machine.execute(notation);
    }


    public ArrayList<Token> buildReversePolishNotation(String equation) throws FormatException {
        Scanner scanner = new Scanner();
        List<Token> tokens = scanner.parse(equation);

        Stack<TokenOperator> opStack = new Stack<>();
        ArrayList<Token> notation = new ArrayList<>();

        for (Token token: tokens) {
            if (token instanceof TokenRealNumber || token instanceof TokenVariable) {
                notation.add(token);
            }
            else if (token instanceof TokenBracketLeft) {
                opStack.push((TokenBracketLeft)token);
            }
            else if (token instanceof TokenBracketRight) {
                while (!opStack.isEmpty()) {
                    Token op = opStack.pop();

                    if (op instanceof TokenBracketLeft) {
                        break;
                    }

                    notation.add(op);
                }
            }
            else if (token instanceof TokenOperator) {
                TokenOperator op = (TokenOperator)token;
                while (!opStack.isEmpty() && opStack.peek().get_priority() >= op.get_priority()) {
                    notation.add(opStack.pop());
                }
                opStack.push(op);
            }
            else {
                throw new FormatException("Invalid equation.");
            }
        }

        while (opStack.size() != 0) {
            notation.add(opStack.pop());
        }

        return notation;
    }
}
