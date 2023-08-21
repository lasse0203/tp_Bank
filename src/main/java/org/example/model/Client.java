package org.example.model;

import java.util.ArrayList;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private ArrayList<BankAccount> bankAccounts=new ArrayList<>();

    public Client(int id, String firstName, String lastName, String numberPhone, ArrayList<BankAccount> bankAccounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = numberPhone;
        this.bankAccounts = bankAccounts;
    }

    public Client(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public Client() {
    }

    public Client(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<org.example.model.BankAccount> getBankAccount() {
        return bankAccounts;
    }

    public void setBankAccount(ArrayList<org.example.model.BankAccount> bankAccount) {
        bankAccounts = bankAccount;
    }

    @Override
    public String toString() {
        return "Client " +
                "id : " + id +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", numberPhone: '" + phoneNumber + '\'' +
                '.';
    }
}
