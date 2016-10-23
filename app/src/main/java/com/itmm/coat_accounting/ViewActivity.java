package com.itmm.coat_accounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.itmm.coat_accounting.database.DBHandler;
import com.itmm.coat_accounting.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ListView listView = (ListView) findViewById(R.id.listView1);

        DBHandler db = new DBHandler(this);

        List<Transaction> transactionList = db.getAllTransactions();

        String[] transactionsNames = new String[db.getTransactionCount()];
        String[] sums = new String[db.getTransactionCount()];

        String[] total = new String[db.getTransactionCount()];

        int index = 0;

        for (Transaction transaction : transactionList) {
            transactionsNames[index] = transaction.getName();

            Double sum = transaction.getSum();
            sums[index] = Double.toString(sum);

            total[index] = transactionsNames[index] + "   " + sums[index];

            index++;
        }

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, total);
        listView.setAdapter(adapter);
    }
}
