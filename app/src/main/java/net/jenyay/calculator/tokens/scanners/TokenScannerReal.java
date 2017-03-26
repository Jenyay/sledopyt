package net.jenyay.calculator.tokens.scanners;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenRealNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenScannerReal implements TokenScanner {
    Pattern _realPattern;

    public TokenScannerReal() {
        _realPattern = Pattern.compile("^\\d*\\.?\\d*");
    }

    @Override
    public Token findToken(String text, Token prevToken) {
        Token nextToken = null;
        Matcher realMatcher = _realPattern.matcher(text);
        boolean findReal = realMatcher.find();
        if (findReal && realMatcher.group().length() != 0 && realMatcher.group() != ".") {
            nextToken = new TokenRealNumber(realMatcher.group());
        }

        return nextToken;
    }
}
