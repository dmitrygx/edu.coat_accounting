package com.itmm.coat_accounting.transaction;

/**
 * Created by Дмитрий on 10/20/2016.
 */


public class Transaction {
    private int id;
    private String name;
    private double sum;
    private int version;

    public Transaction() {
    }

    public Transaction(String name, int id, double sum, int version) {
        this.name = name;
        this.id = id;
        this.sum = sum;
        this.version = version;
    }

    public Transaction(String name, double sum) {
        this.name = name;
        this.sum = sum;
        this.version = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
