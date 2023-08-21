package org.example.service;

import org.example.dao.BankTransactionDAO;
import org.example.model.BankTransaction;

import org.example.model.Client;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankTransactionService {

    private BankTransactionDAO bankTransactionDAO;
    private Connection connection;

    public BankTransactionService() {
        try {
            connection = new DataBaseManager().getConnection();
            bankTransactionDAO = new BankTransactionDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createBankTransaction() {
        BankTransaction banktransaction = new BankTransaction();
        try {
            if(bankTransactionDAO.insert(banktransaction)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updatebankTransaction(BankTransaction banktransaction) {
        try {
            if(bankTransactionDAO.update(banktransaction)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Client getbankTransaction(int id) {
        try {
            return bankTransactionDAO.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<BankTransaction> getAllbankTransactions(int clientId) {
        try {
            return bankTransactionDAO.getByClientId(clientId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

    


