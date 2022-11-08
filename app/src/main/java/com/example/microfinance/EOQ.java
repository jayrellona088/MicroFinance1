package com.example.microfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EOQ extends AppCompatActivity {
    private TextView tv_noOfUnits;
    private EditText et_HoldingCost,et_OderCost,et_DemandInUnits;
    private Button btn_compute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eoq);

        et_HoldingCost = findViewById(R.id.et_HoldingCost);
        et_OderCost = findViewById(R.id.et_OderCost);
        et_DemandInUnits = findViewById(R.id.et_DemandInUnits);

        tv_noOfUnits = findViewById(R.id.tv_noOfUnits);

        btn_compute = findViewById(R.id.btn_compute);


        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int HoldingCost = Integer.parseInt(et_HoldingCost.getText().toString());
                    int OrderCost = Integer.parseInt(et_OderCost.getText().toString());
                    int DemandInUnits = Integer.parseInt(et_DemandInUnits.getText().toString());
                    int UnitTotal = (2 * DemandInUnits * OrderCost) / HoldingCost;
                    double totalUnits = Math.round(Math.sqrt(UnitTotal));
                    int IntValue = (int) totalUnits;
                    String stringdouble= Double.toString(totalUnits);
                    tv_noOfUnits.setText(""+ IntValue);
                }
                catch (Exception e)
                {
                    Toast.makeText(EOQ.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}