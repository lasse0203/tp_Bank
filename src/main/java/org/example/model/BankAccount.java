package org.example.model;

import java.util.ArrayList;

public class BankAccount {

    private int id;
    private Double solde ;
    private Client client ;
    private ArrayList<BankTransaction> bankTransactions =new ArrayList<>();


    public BankAccount(int id, Double solde, Client client, ArrayList<BankTransaction> bankTransactions) {
        this.id = id;
        this.solde = 0.;
        this.client = client;
        this.bankTransactions = bankTransactions;
    }

    public BankAccount(Double solde, Client client) {
        this.solde = solde;
        this.client = client;
    }

    public BankAccount(int id, Double solde) {
        this.id = id;
        this.solde = solde;
    }

    public BankAccount() {
    }

    public BankAccount(double solde) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<BankTransaction> getBankTransactions() {
        return bankTransactions;
    }

    public void setBankTransactions(ArrayList<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", solde=" + solde +
                ", client=" + client +
                ", bankTransactions=" + bankTransactions +
                '}';
    }
}

