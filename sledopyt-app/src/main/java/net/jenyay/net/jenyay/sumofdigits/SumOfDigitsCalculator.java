package net.jenyay.net.jenyay.sumofdigits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jenyay on 05.04.17.
 */

public class SumOfDigitsCalculator {
    private List<Integer> _digits;

    private ArrayList<SumOfDigitEventListener> _listeners;

    public SumOfDigitsCalculator() {
        _digits = new ArrayList<>();
        _listeners = new ArrayList<>();
    }

    public void add(Integer digit) {
        _digits.add(digit);
        processDigitsListChangedEvent(new SumOfDigitEvent(this));
    }

    public void clear() {
        _digits.clear();
        processDigitsListChangedEvent(new SumOfDigitEvent(this));
    }

    public void delete() {
        if (!_digits.isEmpty()) {
            _digits.remove(_digits.size() - 1);
        }
        processDigitsListChangedEvent(new SumOfDigitEvent(this));
    }

    public Integer getResult() {
        int result = 0;
        for (Integer n: _digits) {
            result += n;
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < _digits.size(); i++) {
            if (i != 0) {
                result += " + ";
            }
            result += _digits.get(i).toString();
        }

        return result;
    }

    public synchronized void addOnListChanged(SumOfDigitEventListener listener) {
        if (!_listeners.contains(listener)) {
            _listeners.add(listener);
        }
    }

    private void processDigitsListChangedEvent(SumOfDigitEvent event) {
        ArrayList<SumOfDigitEventListener> tempListeners;

        synchronized (this) {
            if (_listeners.size() == 0)
                return;
            tempListeners = (ArrayList<SumOfDigitEventListener>) _listeners.clone();
        }

        for (SumOfDigitEventListener listener : tempListeners) {
            listener.ListChanged(event);
        }
    }
}
