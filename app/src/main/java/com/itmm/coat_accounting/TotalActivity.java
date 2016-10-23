package com.itmm.coat_accounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.itmm.coat_accounting.database.DBHandler;
import com.itmm.coat_accounting.transaction.Transaction;

import java.util.List;

public class TotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);

        DBHandler db = new DBHandler(this);

        List<Transaction> transactionList = db.getAllTransactions();

        Double totalSum = 0.0;

        for (Transaction transaction : transactionList) {
            totalSum += transaction.getSum();
        }

        TextView sum = (TextView) this.findViewById(R.id.textView2);

        sum.setText(totalSum.toString());

    }
}
