package net.jenyay.sledopyt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private Button _sumNumbersBtn;
    private Button _alphabetBtn;
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

            }
        });

        // Алфавит
        _alphabetBtn = (Button) findViewById(R.id.alphabet);

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
