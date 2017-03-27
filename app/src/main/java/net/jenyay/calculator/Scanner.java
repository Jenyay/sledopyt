package net.jenyay.calculator;

import java.util.LinkedList;
import java.util.List;

import net.jenyay.calculator.exceptions.FormatException;
import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.scanners.TokenScanner;
import net.jenyay.calculator.tokens.scanners.TokenScannerBracketLeft;
import net.jenyay.calculator.tokens.scanners.TokenScannerBracketRight;
import net.jenyay.calculator.tokens.scanners.TokenScannerDiff;
import net.jenyay.calculator.tokens.scanners.TokenScannerDiv;
import net.jenyay.calculator.tokens.scanners.TokenScannerPow;
import net.jenyay.calculator.tokens.scanners.TokenScannerProd;
import net.jenyay.calculator.tokens.scanners.TokenScannerReal;
import net.jenyay.calculator.tokens.scanners.TokenScannerSum;
import net.jenyay.calculator.tokens.scanners.TokenScannerUnaryMinus;
import net.jenyay.calculator.tokens.scanners.TokenScannerUnaryPlus;
import net.jenyay.calculator.tokens.scanners.TokenScannerVariable;


/**
 * Created by jenyay on 26.03.17.
 */

public class Scanner {
    private LinkedList<TokenScanner> _scanners;

    public Scanner() {
        _scanners = new LinkedList<>();
        _scanners.add(new TokenScannerReal());
        _scanners.add(new TokenScannerVariable());
        _scanners.add(new TokenScannerPow());
        _scanners.add(new TokenScannerSum());
        _scanners.add(new TokenScannerDiff());
        _scanners.add(new TokenScannerProd());
        _scanners.add(new TokenScannerDiv());
        _scanners.add(new TokenScannerBracketLeft());
        _scanners.add(new TokenScannerBracketRight());
        _scanners.add(new TokenScannerUnaryMinus());
        _scanners.add(new TokenScannerUnaryPlus());
    }

    public List<Token> parse(String text) throws FormatException {
        LinkedList<Token> result = new LinkedList<>();
        Token prevToken = null;

        text = text.trim();

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
                text = text.trim();
            }
            else {
                throw new FormatException("Invalid string");
            }

            prevToken = nextToken;
        }

        return result;
    }
}
