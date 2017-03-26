package net.jenyay.calculator.tokens.scanners;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenBracketRight;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenScannerBracketRight implements TokenScanner {
    @Override
    public Token findToken(String text, Token prevToken) {
        if (text.startsWith(")")) {
            return new TokenBracketRight();
        }

        return null;
    }
}
