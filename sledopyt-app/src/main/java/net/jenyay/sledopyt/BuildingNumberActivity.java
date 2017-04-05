package net.jenyay.sledopyt;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import net.jenyay.buildingcalculator.BuildingCalculator;
import net.jenyay.calculator.exceptions.CalculatorException;
import net.jenyay.calculator.exceptions.FormatException;
import net.jenyay.calculator.exceptions.UnknownVariableException;


/**
 * Created by jenyay on 16.01.17.
 */

public class BuildingNumberActivity extends Activity {
    private EditText _equation;
    private EditText _streetName;
    private TextView _result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_number);

        _equation = (EditText)findViewById(R.id.equation);
        _streetName = (EditText)findViewById(R.id.street_name);

        _result = (TextView)findViewById(R.id.building_result);

        _equation.addTextChangedListener(new TextChangeListener());
        _streetName.addTextChangedListener(new TextChangeListener());
    }

    class TextChangeListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String equation = _equation.getText().toString();
            String streetName = _streetName.getText().toString();

            BuildingCalculator calculator = new BuildingCalculator();

            try {
                Double result = calculator.calculate(equation, streetName);
                _result.setText(String.valueOf(result));
            }
            catch (FormatException e) {
                _result.setText(R.string.calculator_format_error);
            }
            catch (UnknownVariableException e) {
                String error = getResources().getString(R.string.calculator_unknown_variable) +
                        ": " + e.getVarName();
                _result.setText(error);
            }
            catch (CalculatorException e) {

            }
        }
    };
}
