package net.jenyay.sledopyt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.jenyay.calculator.Calculator;
import net.jenyay.calculator.FormatException;

import java.util.HashMap;

/**
 * Created by jenyay on 16.01.17.
 */

public class BuildingNumberActivity extends Activity {
    private Button _calculateBtn;
    private EditText _equation;
    private TextView _result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_number);

        _equation = (EditText)findViewById(R.id.equation);
        _result = (TextView)findViewById(R.id.building_result);
        _calculateBtn = (Button)findViewById(R.id.calculate_button);

        _calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Integer> variables = new HashMap<String, Integer>();
                Calculator calculator = new Calculator(variables);
                String equation = _equation.getText().toString();

                try {
                    int result = calculator.calculate(equation);
                    _result.setText(String.valueOf(result));
                }
                catch (FormatException e) {

                }
            }
        });
    }
}
