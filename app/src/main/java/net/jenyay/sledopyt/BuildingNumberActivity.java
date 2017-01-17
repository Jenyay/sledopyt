package net.jenyay.sledopyt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jenyay on 16.01.17.
 */

public class BuildingNumberActivity extends Activity {
    private Button _calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_number);

        _calculateBtn = (Button)findViewById(R.id.calculate_button);
        _calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
