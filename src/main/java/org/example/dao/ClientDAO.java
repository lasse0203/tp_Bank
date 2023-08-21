package org.example.dao;

import org.example.model.BankAccount;
import org.example.model.Client;
import org.example.service.ClientService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends BaseDAO<Client> {
    public ClientDAO(Connection connection) {
        super(connection);
    }
    BankAccountDAO bad = new BankAccountDAO(_connection);

    @Override
    public boolean insert(Client element) throws SQLException {
        request = "INSERT INTO Client (first_name, last_name , phone_number ) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        statement.setString(3, element.getPhoneNumber());
       int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();

        if(resultSet.next()){
            element.setId(resultSet.getInt(1));

        }
        BankAccount ba = new BankAccount(0.,element);
        bad.insert(ba);

        return nbRows == 1;
    }


    @Override
    public boolean update(Client element) throws SQLException {
        return false;
    }


    @Override
    public boolean delete(Client element) throws SQLException {
        return false;
    }

    @Override
    public Client get(Client element) throws SQLException {
        return null;
    }


    @Override
    public Client get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Client> get() throws SQLException {
        List<Client> result = new ArrayList<>();
        request = "select * from client";
        statement = _connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while(resultSet.next()){
            Client client = new Client(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("phone_number"));
            result.add(client);
        }
        return result;


    }
}