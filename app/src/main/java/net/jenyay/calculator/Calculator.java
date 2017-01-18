package net.jenyay.calculator;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by jenyay on 17.01.17.
 */

public class Calculator {
    private HashMap<String, Integer> _variables;

    public Calculator(HashMap<String, Integer> variables) {
        _variables = variables;
    }

    public int calculate(String equation) throws FormatException {
        ArrayList<Token> notation = buildReversePolishNotation(equation);

        return 0;
    }

    public ArrayList<Token> buildReversePolishNotation(String equation) throws FormatException {
        equation = equation.replace(" ", "");

        ArrayList<Token> opStack = new ArrayList<Token>();
        ArrayList<Token> notation = new ArrayList<Token>();

        for(char c : equation.toCharArray()) {
            // Letter or digit
            if (Character.isDigit(c) || Character.isLetter(c)) {

                if (notation.size() != 0 &&
                        notation.get(notation.size() - 1).getType() == Token.Type.VALUE) {
                    Token lastToken = notation.get(notation.size() - 1);
                    lastToken.setValue(lastToken.getValue() + c);
                }
                else {
                    notation.add(new Token(Token.Type.VALUE, String.valueOf(c), -1));
                }

                continue;
            }

            // Open bracket
            if (c == '(') {
                opStack.add(new Token(Token.Type.BRACKET_OPEN, String.valueOf(c), 0));
            }

            // Close bracket
            if (c == ')') {
                while (opStack.size() != 0) {
                    Token op = opStack.get(0);
                    opStack.remove(0);

                    if (op.getType() != Token.Type.BRACKET_OPEN) {
                        notation.add(op);
                    }
                    else {
                        break;
                    }
                }
                continue;
            }

            if ("+-*/".indexOf(c) != -1) {
                Token op;
                switch (c) {
                    case '+':
                    case '-':
                        op = new Token(Token.Type.OPERATOR, String.valueOf(c), 2);
                        break;

                    case '*':
                    case '/':
                        op = new Token(Token.Type.OPERATOR, String.valueOf(c), 3);
                        break;

                    case '^':
                        op = new Token(Token.Type.OPERATOR, String.valueOf(c), 4);
                        break;

                    default:
                        throw new FormatException("");
                }

                while (opStack.size() != 0 && opStack.get(0).getPriority() >= op.getPriority()) {
                    notation.add(opStack.get(0));
                    opStack.remove(0);
                }
                opStack.add(op);
                continue;
            }
        }

        while (opStack.size() != 0) {
            notation.add(opStack.get(0));
            opStack.remove(0);
        }

        return notation;
    }
}
