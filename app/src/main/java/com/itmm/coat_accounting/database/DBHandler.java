package com.itmm.coat_accounting.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.itmm.coat_accounting.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Дмитрий on 10/20/2016.
 */

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accounting";

    private static final String TABLE_TRANSACTION_DETAIL = "transactionDetails";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SUM = "sum";
    private static final String KEY_VERSION = "version";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_TRANSACTION_DETAIL_TABLE = "CREATE TABLE " + TABLE_TRANSACTION_DETAIL + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_SUM + " TEXT,"
                + KEY_VERSION + " TEXT " + ")";

        db.execSQL(CREATE_TRANSACTION_DETAIL_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addNewTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, transaction.getName());
        values.put(KEY_SUM, transaction.getSum());
        values.put(KEY_VERSION, transaction.getVersion());

        db.insert(TABLE_TRANSACTION_DETAIL, null, values);
        db.close();
    }

    public Transaction getTransaction(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TRANSACTION_DETAIL, new String[] {
                KEY_ID,
                KEY_NAME,
                KEY_SUM,
                KEY_VERSION
        }, KEY_ID + "=?",
        new String[]{
                String.valueOf(id)
        }, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Transaction transaction = new Transaction(cursor.getString(1),
                Integer.parseInt(cursor.getString(0)),
                Double.parseDouble(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)));

        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactionsList = new ArrayList<Transaction>();
        String selectQuery = "SELECT * FROM " + TABLE_TRANSACTION_DETAIL;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Transaction transaction = new Transaction();

                transaction.setId(Integer.parseInt(cursor.getString(0)));
                transaction.setName(cursor.getString(1));
                transaction.setSum(Double.parseDouble(cursor.getString(2)));
                transaction.setVersion(Integer.parseInt(cursor.getString(3)));

                transactionsList.add(transaction);
            } while (cursor.moveToNext());
        }

        return transactionsList;
    }

    public int getTransactionCount() {
        String countQuery = "SELECT * FROM " + TABLE_TRANSACTION_DETAIL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }
}
