package net.jenyay.calculator.tokens.scanners;

import net.jenyay.calculator.tokens.Token;

/**
 * Created by jenyay on 26.03.17.
 */

public interface TokenScanner {
    Token findToken(String text, Token prevToken);
}
