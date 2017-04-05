package net.jenyay.net.jenyay.sumofdigits;

import java.util.EventObject;

/**
 * Created by jenyay on 05.04.17.
 */

public class SumOfDigitEvent extends EventObject {
    /**
     * Constructs a new instance of this class.
     *
     * @param source the object which fired the event.
     */
    public SumOfDigitEvent(Object source) {
        super(source);
    }

    public SumOfDigitsCalculator getCalculator() {
        return (SumOfDigitsCalculator)source;
    }
}
