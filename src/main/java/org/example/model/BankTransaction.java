package org.example.model;

public class BankTransaction {
    private int id;
    private double amount;

    private Status staus;


    public BankTransaction(int id, double amount, Status staus) {
        this.id = id;
        this.amount = amount;
        this.staus = staus;
    }

    public BankTransaction(double amount, Status staus) {
        this.amount = amount;
        this.staus = staus;
    }

    public BankTransaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStaus() {
        return staus;
    }

    public void setStaus(Status staus) {
        this.staus = staus;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", staus=" + staus +
                '}';
    }
}
