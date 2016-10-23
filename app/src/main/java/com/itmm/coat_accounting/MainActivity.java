package com.itmm.coat_accounting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonHandler.ButtonPressed {

    ButtonHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickHandler = new ButtonHandler(this, this);
    }

    @Override
    public void buttonExpense() {
        Intent myIntent = new Intent(MainActivity.this, ExpenseActivity.class);

        MainActivity.this.startActivity(myIntent);
    }

    @Override
    public void buttonIncome() {
        Intent myIntent = new Intent(MainActivity.this, IncomeActivity.class);

        MainActivity.this.startActivity(myIntent);
    }

    @Override
    public void buttonTotal() {
        Intent myIntent = new Intent(MainActivity.this, TotalActivity.class);

        MainActivity.this.startActivity(myIntent);
    }

    @Override
    public void buttonView() {
        Intent myIntent = new Intent(MainActivity.this, ViewActivity.class);

        MainActivity.this.startActivity(myIntent);
    }
}
