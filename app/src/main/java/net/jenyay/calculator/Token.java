package net.jenyay.calculator;

/**
 * Created by jenyay on 17.01.17.
 */

public class Token {


    public enum Type { VALUE, BRACKET_OPEN, OPERATOR }

    private Type _type;

    private String _value;
    private int _priority;

    public void setType(Type type) {
        this._type = type;
    }
    public Type getType() {
        return _type;
    }

    public int getPriority() { return _priority; }
    public void setPriority(int priority) { this._priority = priority; }

    public String getValue() {
        return _value;
    }
    public void setValue(String value) {
        this._value = value;
    }

    public Token(Type type, String value, int priority) {
        _type = type;
        _value = value;
        _priority = priority;
    }

    public String toString() {
        return _value;
    }
}
