package net.jenyay.sledopyt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.jenyay.net.jenyay.sumofdigits.SumOfDigitEvent;
import net.jenyay.net.jenyay.sumofdigits.SumOfDigitEventListener;
import net.jenyay.net.jenyay.sumofdigits.SumOfDigitsCalculator;

public class SumOfDigits extends Activity {
    private TextView _digits;
    private TextView _result;

    private Button[] _digitButtons;

    private Button _delete;
    private Button _clear;

    private SumOfDigitsCalculator _calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_of_digits);

        _calculator = new SumOfDigitsCalculator();

        _digits = (TextView)findViewById(R.id.digits);
        _result = (TextView)findViewById(R.id.result);

        _digitButtons = new Button[]{
                (Button) findViewById(R.id.digit_0),
                (Button) findViewById(R.id.digit_1),
                (Button) findViewById(R.id.digit_2),
                (Button) findViewById(R.id.digit_3),
                (Button) findViewById(R.id.digit_4),
                (Button) findViewById(R.id.digit_5),
                (Button) findViewById(R.id.digit_6),
                (Button) findViewById(R.id.digit_7),
                (Button) findViewById(R.id.digit_8),
                (Button) findViewById(R.id.digit_9)
        };

        _delete = (Button)findViewById(R.id.delete);
        _clear = (Button)findViewById(R.id.clear);

        _calculator.addOnListChanged(new SumOfDigitEventListener() {
            @Override
            public void ListChanged(SumOfDigitEvent e) {
                _digits.setText(e.getCalculator().toString());
                _result.setText(e.getCalculator().getResult().toString());
            }
        });

        for (int i = 0; i <= 9; i++) {
            _digitButtons[i].setOnClickListener(new DigitEventHandler(i));
        }

        _delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _calculator.delete();
            }
        });

        _clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _calculator.clear();
            }
        });
    }

    class DigitEventHandler implements View.OnClickListener {
        Integer _digit;

        public DigitEventHandler(int digit) {
            _digit = digit;
        }

        @Override
        public void onClick(View v) {
            _calculator.add(_digit);
        }
    }
}
