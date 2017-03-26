package net.jenyay.calculator;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by jenyay on 17.01.17.
 */

public class Calculator {
    private HashMap<String, Double> _variables;

    public Calculator(HashMap<String, Double> variables) {
        _variables = variables;
    }

    public Double calculate(String equation) throws FormatException {
        ArrayList<TokenOld> notation = buildReversePolishNotation(equation);
        StackMachine machine = new StackMachine(_variables);
        return machine.execute(notation);
    }


    public ArrayList<TokenOld> buildReversePolishNotation(String equation) throws FormatException {
        equation = equation.replace(" ", "");

        ArrayList<TokenOld> opStack = new ArrayList<>();
        ArrayList<TokenOld> notation = new ArrayList<>();

        boolean startValue = false;

        for(char c : equation.toCharArray()) {
            // Letter or digit
            if (Character.isDigit(c) || Character.isLetter(c)) {
                if (startValue) {
                    TokenOld lastToken = notation.get(notation.size() - 1);
                    lastToken.setValue(lastToken.getValue() + c);
                }
                else {
                    notation.add(new TokenOld(TokenOld.Type.VALUE, String.valueOf(c), -1));
                    startValue = true;
                }

                continue;
            }
            startValue = false;

            // Open bracket
            if (c == '(') {
                opStack.add(0, new TokenOld(TokenOld.Type.BRACKET_OPEN, String.valueOf(c), 0));
                continue;
            }

            // Close bracket
            if (c == ')') {
                while (opStack.size() != 0) {
                    TokenOld op = opStack.get(0);
                    opStack.remove(0);

                    if (op.getType() != TokenOld.Type.BRACKET_OPEN) {
                        notation.add(op);
                    }
                    else {
                        break;
                    }
                }
                continue;
            }

            if ("+-*/^".indexOf(c) != -1) {
                TokenOld op;
                switch (c) {
                    case '+':
                    case '-':
                        op = new TokenOld(TokenOld.Type.OPERATOR, String.valueOf(c), 2);
                        break;

                    case '*':
                    case '/':
                        op = new TokenOld(TokenOld.Type.OPERATOR, String.valueOf(c), 3);
                        break;

                    case '^':
                        op = new TokenOld(TokenOld.Type.OPERATOR, String.valueOf(c), 4);
                        break;

                    default:
                        throw new FormatException("");
                }

                while (opStack.size() != 0 && opStack.get(0).getPriority() >= op.getPriority()) {
                    notation.add(opStack.get(0));
                    opStack.remove(0);
                }
                opStack.add(0, op);
            }
            else {
                throw new FormatException("Invalid characters in the equation.");
            }
        }

        while (opStack.size() != 0) {
            notation.add(opStack.get(0));
            opStack.remove(0);
        }

        return notation;
    }
}
