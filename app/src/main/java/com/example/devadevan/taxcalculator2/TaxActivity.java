package com.example.devadevan.taxcalculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaxActivity extends AppCompatActivity {

    TextView txtResult,txtNetIncome,txtRebate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        int income = getIntent().getIntExtra("NET",0);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtRebate=(TextView) findViewById(R.id.txtRebate);
        txtNetIncome = (TextView) findViewById(R.id.txtNetIncome);

        txtNetIncome.setText("Net Taxable Income is \nRs. " + income);
        int tax=0, cess=0, rebate=0;
        if(income > 0)
        {
            if (income > 1000000)
                tax = 125000 + (int) ((income - 1000000) * 0.3);
            else if (income > 500000)
                tax = 25000 + (int) ((income - 500000) * 0.2);
            else if (income > 250000) {
                tax = (int) ((income - 250000) * 0.1);
                rebate = (tax < 5000) ? tax : 5000;
            }
            txtRebate.setText("Rebate U/s.87-A is \n"+rebate);
            tax = tax - rebate;
            if (tax > 0) {
                cess = (int) (tax * 0.03);
                tax = tax + cess;
            }
            if (tax == 0 && rebate > 0)
                txtResult.setText("Your income tax of Rs." + rebate + " is exempted U/s 87A");
            else if (tax == 0)
                txtResult.setText("Your income is within non-taxable limit");
            else
                txtResult.setText("Income tax payable is \nRs. " + tax);
        }
        else {
            txtResult.setText("Your income is not taxable");
        }
    }
}
