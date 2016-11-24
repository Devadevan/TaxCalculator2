package com.example.devadevan.taxcalculator2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IncomeActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText editIncome1, editIncome2, editIncome3, editSavings, editPremium;
    TextView txtNetIncome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editIncome1 = (EditText) findViewById(R.id.editSalary);
                editIncome2 = (EditText) findViewById(R.id.editOtherIncome);
                editIncome3 = (EditText) findViewById(R.id.editHouseIncome);
                editSavings = (EditText) findViewById(R.id.editSavings);
                editPremium = (EditText) findViewById(R.id.editMedPremium);
                String str;
                int in1 = 0,in2 = 0,in3 = 0, totIncome, ded1 = 0, ded2 = 0, totDed, net = 0;
                str = editIncome1.getText().toString();
                if(str.length()>0) in1=Integer.parseInt(str);
                str = editIncome2.getText().toString();
                if(str.length()>0) in2=Integer.parseInt(str);
                str = editIncome3.getText().toString();
                if(str.length()>0) in3=Integer.parseInt(str);
                str = editSavings.getText().toString();
                if(str.length()>0) ded1=Integer.parseInt(str);
                if (ded1>150000) ded1=150000;
                str = editPremium.getText().toString();
                if(str.length()>0) ded2=Integer.parseInt(str);
                if(ded2>15000) ded2=15000;
                totIncome = in1+in2+in3;
                totDed = ded1+ded2;
                net = totIncome-totDed;
                if (net<0) net=0;
                if(net>0) {
                    Intent i = new Intent(getBaseContext(), TaxActivity.class);
                    i.putExtra("NET", net);
                    startActivity(i);
                }
                else
                    Toast.makeText(getBaseContext(),"No income to calculate tax",Toast.LENGTH_LONG).show();
            }
        });
    }
}
