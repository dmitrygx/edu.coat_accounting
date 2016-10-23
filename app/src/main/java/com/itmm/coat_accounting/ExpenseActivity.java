package com.itmm.coat_accounting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itmm.coat_accounting.database.DBHandler;
import com.itmm.coat_accounting.transaction.Transaction;

public class ExpenseActivity extends AppCompatActivity {

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        db = new DBHandler(this);
    }

    public void onClickExpense(View view) {
        EditText name = (EditText) this.findViewById(R.id.editText1);
        EditText sum = (EditText) this.findViewById(R.id.editText2);
        Transaction transaction = new Transaction(name.getText().toString(), -1 * Double.parseDouble(sum.getText().toString()));
        db.addNewTransaction(transaction);

        this.finish();
    }
}
