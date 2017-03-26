package net.jenyay.calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenRealNumber;
import net.jenyay.calculator.tokens.scanners.TokenScanner;
import net.jenyay.calculator.tokens.scanners.TokenScannerReal;


/**
 * Created by jenyay on 26.03.17.
 */

public class Scanner {
    LinkedList<TokenScanner> _scanners;

    public Scanner() {
        _scanners = new LinkedList();
        _scanners.add(new TokenScannerReal());
    }

    public List<Token> parse(String text) throws FormatException {
        LinkedList<Token> result = new LinkedList();
        Token prevToken = null;

        while (!text.isEmpty()) {
            Token nextToken = null;

            for (TokenScanner scanner: _scanners) {
                nextToken = scanner.findToken(text, prevToken);

                if (nextToken != null) {
                    break;
                }
            }

            if (nextToken != null) {
                result.add(nextToken);
                text = text.substring(nextToken.get_value().length());
            }
            else {
                throw new FormatException("Invalid string");
            }

            prevToken = nextToken;
        }

        return result;
    }
}
