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
    private static BankClientDAO dao = getBankClientDAO();

    public  BankClientService  (){

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
            List<BankClient> bankClients=getAllClient();
            for(BankClient bankClient:bankClients)
                if(bankClient.getName().equals(client.getName()))
                    return false;
            dao.addClient(client);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean isAllNotNull(String senderName, String senderPass, String nameTo, String stringCount) {
        boolean qq=senderName!=null &&stringCount!=null &&nameTo!=null;
        boolean q= senderName!=null;
        return q&&qq;
    }
    public boolean sendMoneyToClient(BankClient sender, String name, Long value) {
        try {
            if(!isAllNotNull(sender.getName(),sender.getPassword(),name,value.toString())){
                return false;
            }
            if(sender.getName().equals(name))
                return false;
         //   SqlTransaction    transaction = connection.BeginTransaction("SampleTransaction");
            BankClient reciver=getClientByName(name);
            getMysqlConnection().setAutoCommit(false);
            getMysqlConnection().commit();
            dao.updateClientsMoney(sender.getName(),sender.getPassword(),-value);
            dao.updateClientsMoney(reciver.getName(),reciver.getPassword(),value);
            getMysqlConnection().commit();
     //       getMysqlConnection().setAutoCommit(true);
        } catch (SQLException | DBException e) {
            e.printStackTrace();
            try {
                getMysqlConnection().rollback();
                getMysqlConnection().setAutoCommit(true);
            } catch (SQLException ignore) {
               ignore.printStackTrace();
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
            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:postgresql://").        //db type
                    append("localhost:").           //host name
                    append("5432/").                //port
                    append("db_example?").          //db name
               //     append("user=root&").          //login
                       append("user=postgres&").
                    append("password=123");       //password

            System.out.println("URL: " + url + "\n");

           Connection connection = DriverManager.getConnection(url.toString());
           String g = "jdbc:postgresql://localhost/db_example?user=postgres&password=123";
       //     Connection connection = DriverManager.getConnection(g);
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
