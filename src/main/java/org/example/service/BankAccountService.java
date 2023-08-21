package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.model.BankAccount;
import org.example.model.Client;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class BankAccountService{
    private BankAccountDAO bankAccountDAO;
    private Connection connection;

    public BankAccountService() {
        try {
            connection = new DataBaseManager().getConnection();
            bankAccountDAO = new BankAccountDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createbankAccount(double solde) {
        BankAccount bankAccount = new BankAccount(solde);
        try {
            if(bankAccountDAO.insert(bankAccount)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updatebankAccount(BankAccount bankAccount) {
        try {
            if(bankAccountDAO.update(bankAccount)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Client getbankAccount(int id) {
        try {
            return bankAccountDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public boolean deletebankAccount(int id) {
        Client bankAccount = null;
        try {
            bankAccount = bankAccountDAO.get(id);
            if(bankAccount != null) {
                return bankAccountDAO.delete(bankAccount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }*/

    public List<BankAccount> getAllbankAccount() {
        try {
            return bankAccountDAO.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }  public List<BankAccount> getBankAccountsByClientId(int clientId) {
        try {
            return bankAccountDAO.getBankAccountsByClientId(clientId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
