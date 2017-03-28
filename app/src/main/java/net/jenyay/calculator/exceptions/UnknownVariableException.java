package net.jenyay.calculator.exceptions;

/**
 * Created by jenyay on 28.03.17.
 */

public class UnknownVariableException extends CalculatorException {
    private String _varName;

    public String getVarName() {
        return _varName;
    }

    public UnknownVariableException(String varname) {
        super("Unknown variable: " + varname);
        _varName = varname;
    }

    public String toString() {
        return "(UnknownVariableException) " + getText();
    }
}
