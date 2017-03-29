package net.jenyay.calculator.tokens.scanners;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenPow;

/**
 * Created by jenyay on 27.03.17.
 */

public class TokenScannerPow implements TokenScanner {
    @Override
    public Token findToken(String text, Token prevToken) {
        if (text.startsWith("^")) {
            return new TokenPow("^");
        }

        if (text.startsWith("**")) {
            return new TokenPow("**");
        }

        return null;
    }
}
