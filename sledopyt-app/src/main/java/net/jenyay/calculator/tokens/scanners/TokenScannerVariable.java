package net.jenyay.calculator.tokens.scanners;

import net.jenyay.calculator.tokens.Token;
import net.jenyay.calculator.tokens.TokenVariable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jenyay on 26.03.17.
 */

public class TokenScannerVariable implements TokenScanner {
    Pattern _pattern;

    public TokenScannerVariable(){
        _pattern = Pattern.compile("^[_\\p{L}]+[_\\p{L}\\d]*", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public Token findToken(String text, Token prevToken) {
        Token nextToken = null;
        Matcher realMatcher = _pattern.matcher(text);
        boolean findReal = realMatcher.find();
        if (findReal) {
            nextToken = new TokenVariable(realMatcher.group());
        }

        return nextToken;
    }
}
