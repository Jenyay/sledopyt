package net.jenyay.calculator.tokens.scanners;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenBracketLeft;
import net.jenyay.calculator.tokens.TokenSum;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenScannerSum implements TokenScanner {
    @Override
    public Token findToken(String text, Token prevToken) {
        if (text.startsWith("+") &&
                prevToken != null &&
                !(prevToken instanceof TokenBracketLeft)) {
            return new TokenSum();
        }

        return null;
    }
}
