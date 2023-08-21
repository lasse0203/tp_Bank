package org.example.dao;

import org.example.model.BankAccount;
import org.example.model.Client;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDAO extends BaseDAO<BankAccount>{
    public BankAccountDAO(Connection connection) {
        super(connection);
    }


    @Override
    public boolean insert(BankAccount element) throws SQLException {
            request = "INSERT INTO bank_account (solde , client_id)  VALUES (?,?)";
            statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, element.getSolde());
            statement.setInt(2, element.getClient().getId());
            int nbRows = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            return nbRows == 1;
        }


    @Override
    public boolean update(BankAccount element) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException {
        return false;
    }

    @Override
    public BankAccount get(BankAccount element) throws SQLException {
        return null;
    }


    @Override
    public Client get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<BankAccount> get() throws SQLException {
        return null;
    }

    public List<BankAccount> getBankAccountsByClientId(int clientId) throws SQLException {
        request = "select * from bank_account where client_id = ? ";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, clientId);
        resultSet = statement.executeQuery();
        List<BankAccount> result = new ArrayList<>();
        while(resultSet.next()){
            BankAccount bankAccount = new BankAccount(resultSet.getInt("id"),
                    resultSet.getDouble("solde"));

            result.add(bankAccount);
        }
        return result;
    }
}
