package com.example.splitbill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class input extends AppCompatActivity {

    double bill;
    double tax = .18;
    int guest;
    double finalCost;
    String exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final EditText finalGuest = (EditText)findViewById(R.id.numGuest);
        final EditText finalBill = (EditText)findViewById(R.id.billCost);
        final Spinner finalRating = (Spinner)findViewById(R.id.rating);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v){
                guest = Integer.parseInt(finalGuest.getText( ).toString( ));
                bill = Integer.parseInt(finalBill.getText( ).toString( ));
                finalCost = (bill * (1+tax)) / guest;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                exp = finalRating.getSelectedItem( ).toString( );
                result.setText("Bill per person is " + currency.format(finalCost));

            }
        });
    }
}
