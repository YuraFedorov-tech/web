package service;

import dao.BankClientDAO;
import exception.DBException;
import model.BankClient;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class BankClientService {
    private BankClientDAO dao;
    public BankClientService() {
        dao=getBankClientDAO();
    }

    public BankClient getClientById(long id) throws DBException {
        try {
            return getBankClientDAO().getClientById(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public BankClient getClientByName(String name) {

        try {
            return dao.getClientByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BankClient> getAllClient() {
        try {
            return  dao.getAllBankClient();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteClient(String name) {
        try {
            dao.deleteClient(name);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addClient(BankClient client)  {
        try {
            dao.addClient(client);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendMoneyToClient(BankClient sender, String name, Long value) {
        synchronized (this) {
            try {


                BankClient bankClient = getClientByName(name);
                getMysqlConnection().setAutoCommit(false);
                dao.updateClientsMoney(sender.getName(), sender.getPassword(), -value);
                dao.updateClientsMoney(bankClient.getName(), bankClient.getPassword(), value);
                getMysqlConnection().commit();
                return true;
            } catch (SQLException | DBException e) {
                try {
                    getMysqlConnection().rollback();
                    getMysqlConnection().setAutoCommit(true);
                } catch (SQLException ignore) {
                }
            }
        }
        return false;
    }

    public void cleanUp() throws DBException {
        BankClientDAO dao = getBankClientDAO();
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
    public void createTable() throws DBException{
        BankClientDAO dao = getBankClientDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=123");       //password

            System.out.println("URL: " + url + "\n");

           // Connection connection = DriverManager.getConnection(url.toString());
            String g = "jdbc:mysql://localhost/db_example?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false&user=root&password=123";
            Connection connection = DriverManager.getConnection(g);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static BankClientDAO getBankClientDAO() {
        return new BankClientDAO(getMysqlConnection());
    }
}
