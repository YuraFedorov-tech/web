package service;

import dao.BankClientDAO;
import exception.DBException;
import model.BankClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BankClientService {
    private static BankClientService bankClientService;
    private BankClientDAO dao = getBankClientDAO();

    public BankClientService() {
    }

    public static BankClientService getInstance() {

        return bankClientService;
    }

    public BankClient getClientById(long id) throws DBException {
        try {
            return dao.getClientById(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public BankClient getClientByName(String name) {

        try {
            return dao.getClientByName(name);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<BankClient> getAllClient() {
        try {
            return dao.getAllBankClient();
        } catch (SQLException e) {
            return new ArrayList<BankClient>();
        }

    }

    public boolean deleteClient(String name) {

        try {
            dao.deleteClient(name);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean addClient(BankClient client) throws DBException {
        try {
            List<BankClient> clients = getAllClient();
            if (isHasClientForNameInBase(client.getName(), clients))
                throw new DBException();
            dao.addClient(client);
            dao.createTable();
            return true;


        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean sendMoneyToClient(BankClient sender, String name, Long value) throws DBException {

        try {
            List<BankClient> clients = getAllClient();
            if (isHasClientForNameInBase(sender.getName(), sender.getPassword(), clients) && isHasClientForNameInBase(name, clients)) {
                BankClient bankClient = getClientByName(name);
                dao.updateClientsMoney(sender.getName(), sender.getPassword(), -value);
                dao.updateClientsMoney(bankClient.getName(), bankClient.getPassword(), value);
                return true;
            }

        } catch (SQLException e) {

            throw new DBException(e);
        }
        throw new DBException();
    }

    private boolean isHasClientForNameInBase(String name, String password, List<BankClient> clients) {
        for (BankClient client : clients) {
            if (client.getName().equals(name) && client.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean isHasClientForNameInBase(String name, List<BankClient> clients) {
        for (BankClient client : clients) {
            if (client.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanUp() throws DBException {
        //     BankClientDAO dao = getBankClientDAO();
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void createTable() throws DBException {
        //      BankClientDAO dao = getBankClientDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    private static BankClientDAO getBankClientDAO() {
        return new BankClientDAO(getMysqlConnection());
    }

    private static Connection getMysqlConnection() {
//        try {
//            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
//
//            StringBuilder url = new StringBuilder();
//
//            url.
//                    append("jdbc:mysql://").        //db type
//                    append("localhost:").           //host name
//                    append("3306/").                //port
//                    append("db_example?").          //db name
//                    append("user=root&").          //login
//                    append("password=root");       //password
//
//            System.out.println("URL: " + url + "\n");
//
//            Connection connection = DriverManager.getConnection(url.toString());
//            return connection;
//        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new IllegalStateException();
//        }
//        try {
//            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());
//            StringBuilder url = new StringBuilder();
//            url.append("jdbc:postgresql://").        //db type
//                    append("localhost:").           //host name
//                    append("5432/").                //port
//                    append("bank_client?").          //db name
//                    append("user=postgres&").          //login
//                    append("password=123");       //password
//            System.out.println("URL: " + url + "\n");
//            Connection connection = DriverManager.getConnection(url.toString());
//            return connection;
//        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//            throw new IllegalStateException();
//        }
        Connection connection;
        try {

            String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
            String dbUsername = "postgres";
            String dbPassword = "123";
            String dbDriverClassName = "org.postgresql.Driver";
            Class.forName(dbDriverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }


    }


}
