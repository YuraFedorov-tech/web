package service;

import dao.BankClientDAO;
import exception.DBException;
import freemarker.template.Configuration;
import model.BankClient;
import util.PageGenerator;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class BankClientService {

    private static BankClientService bankClientService;
    private static BankClientDAO dao = getBankClientDAO();

    public static BankClientService getInstance() {
        if (bankClientService == null) {
            bankClientService = new BankClientService();
        }
        return bankClientService;
    }

    private BankClientService() {
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
            BankClient bankClient = dao.getClientByName(name);
            return bankClient;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BankClient> getAllClient() {
        return dao.getAllBankClient();
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

    public boolean addClient(BankClient client) throws DBException {
        try {
            dao.addClient(client);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean sendMoneyToClient(BankClient sender, String name, Long value) {
        try {
            BankClient reciver=getClientByName(name);
            getMysqlConnection().setAutoCommit(false);
            dao.updateClientsMoney(sender.getName(),sender.getPassword(),-value);
            dao.updateClientsMoney(reciver.getName(),reciver.getPassword(),value);
            getMysqlConnection().commit();
        } catch (SQLException | DBException e) {
            e.printStackTrace();
            try {
                getMysqlConnection().rollback();
                getMysqlConnection().setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
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

    public void createTable() throws DBException {
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
                    append("bank?").          //db name
                    append("user=root&").          //login
                    append("password=123");       //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
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
