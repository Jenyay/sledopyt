package net.jenyay.sledopyt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button _sumNumbersBtn;
    private Button _buildingNumberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Сумма цифр
        _sumNumbersBtn = (Button)findViewById(R.id.sum_numbers);
        _sumNumbersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SumOfDigits.class);
                startActivity(intent);
            }
        });

        // Расчет номера дома
        _buildingNumberBtn = (Button) findViewById(R.id.building_number);
        _buildingNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BuildingNumberActivity.class);
                startActivity(intent);
            }
        });
    }

}
