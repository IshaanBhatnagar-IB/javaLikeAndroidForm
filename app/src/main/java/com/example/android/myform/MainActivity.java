package com.example.android.myform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int qty=1;
    int unitPrice=5;

    public void submitOrder(View view) {

        display(qty);
        displayPrice();
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String text="" + number;
        quantityTextView.setText(text);
    }

    public void inc(View view)
    {
        if(qty<50) {
            qty++;
            display(qty);
        }
    }
    public void dec(View view)
    {
        if(qty>=1)
        {
            qty--;
            display(qty);
        }
    }

    private void displayPrice()
    {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        int totalPrice=unitPrice*qty;
        String text="";
        CheckBox cbI=findViewById(R.id.cbIceCream);
        CheckBox cbK=findViewById(R.id.cbKitkat);
        if(cbI.isChecked())
        {
            text+="\nTopping:"+cbI.getText();
            totalPrice+=15*qty;
        }
        if(cbK.isChecked())
        {
            text+="\nTopping:"+cbK.getText();
            totalPrice+=10*qty;
        }
        EditText et=findViewById(R.id.nameText);
        text+="\nThanks "+et.getText();
        priceTextView.setText("Total Price="+NumberFormat.getCurrencyInstance().format(totalPrice)+text);
    }
}