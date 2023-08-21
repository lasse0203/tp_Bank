package org.example.service;
import org.example.dao.ClientDAO;
import org.example.model.Client;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClientService {
        private ClientDAO clientDAO;
        private Connection connection;

        public ClientService() {
            try {
                connection = new DataBaseManager().getConnection();
                clientDAO = new ClientDAO(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean createClient(String firstName, String lastName,String PhoneNumber) {
            Client client = new Client(firstName, lastName, PhoneNumber);
            try {
                if(clientDAO.insert(client)) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }

        public boolean updateClient(Client client) {
            try {
                if(clientDAO.update(client)) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }

        public Client getClient(int id) {
            try {
                return clientDAO.get(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean deleteClient(int id) {
            Client Client = null;
            try {
                Client = clientDAO.get(id);
                if(Client != null) {
                    return clientDAO.delete(Client);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return false;
        }

        public List<Client> getAllClients() {
            try {
                return clientDAO.get();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

