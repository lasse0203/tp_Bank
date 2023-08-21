package org.example.dao;

import org.example.model.BankTransaction;
import org.example.model.Client;
import org.example.model.Status;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionDAO extends BaseDAO<BankTransaction> {


    public BankTransactionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(BankTransaction element ) throws SQLException {
        request = "INSERT INTO transaction (amount , status, account_id)  VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getAmount());
        statement.setString(2, String.valueOf(element.getStaus()));
        //statement.setInt(3, element.get);

        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }



    @Override
    public boolean update(BankTransaction element) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(BankTransaction element) throws SQLException {
        return false;
    }

    @Override
    public BankTransaction get(BankTransaction element) throws SQLException {
        return null;
    }

    @Override
    public Client get(int id) throws SQLException {
        return null;
    }


    @Override
    public List<BankTransaction> get() throws SQLException {
        return null;
    }

    public List<BankTransaction> getByClientId(int clientId) throws SQLException {
        List<BankTransaction> BankTransactions = new ArrayList<>();
        request = "SELECT * from transaction where account_id in (SELECT id FROM bank_account where client_id =  ?) ";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,clientId );
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            BankTransaction bankTransaction = new BankTransaction(resultSet.getInt("id"),
                    resultSet.getDouble("amount"),
                    Status.valueOf(resultSet.getString("status")));
            BankTransactions.add(bankTransaction);
        }
        return BankTransactions;
    }
}
