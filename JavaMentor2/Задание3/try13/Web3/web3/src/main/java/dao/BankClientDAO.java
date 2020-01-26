package dao;

import com.sun.deploy.util.SessionState;
import exception.DBException;
import model.BankClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankClientDAO  {
    //language=SQL
    private final String SQL_ADD_MODEL = "INSERT INTO bank_client(name, password, money) VALUES (?,?,?)";
    //language=SQL
    private final String SQL_FIND_ALL_CLIENT = "SELECT * FROM bank_client";
    //language=SQL
    private final String SQL_FIND_CLIENT_BY_NAME = "SELECT FROM bank_client WHERE NAME =?";
    //language=SQL
    private final String SQL_Updates_Client_money = "UPDATE bank_client SET money=? WHERE id=?";
    //language=SQL
    private final String SQL_DELETE_BY_NAME = "DELETE FROM bank_client WHERE name=?";
    private Connection connection;

    public BankClientDAO(Connection connection) {

        this.connection = connection;
    }

    public void updateClientsMoney(String name, String password, Long transactValue) throws SQLException, DBException {
        //updateClientsMoney() должен вызываться с положительным transactValue,
        // если средства начисляются, и с отрицательным, если списываются.

        BankClient client = getClientByName(name);
        if (!validateClient(name, password)) {
            throw new DBException();
        }



        Long newMonew = client.getMoney() + transactValue;
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_Updates_Client_money);
        preparedStatement.setLong(1, newMonew);
        preparedStatement.setLong(2, client.getId());
       preparedStatement.execute();
        preparedStatement.close();


    }



    public List<BankClient> getAllBankClient()  {
        List<BankClient> clients = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(SQL_FIND_ALL_CLIENT);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Long money = Long.parseLong(resultSet.getString("money"));
                clients.add(new BankClient(id, name, password, money));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }


    public boolean validateClient(String name, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where name='" + name + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        String passwordInBase = result.getString("password");
        result.close();
        stmt.close();
        return password.equals(passwordInBase);
    }


    public BankClient getClientById(long idCur) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where name='" + idCur + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        Long id = result.getLong("id");
        String name = result.getString("name");
        String password = result.getString("password");
        Long money = Long.parseLong(result.getString("money"));
        result.close();
        stmt.close();
        return new BankClient(id, name, password, money);
    }

    public boolean isClientHasSum(String name, Long expectedSum) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where name='" + name + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        Long money = result.getLong("money");
        result.close();
        stmt.close();
        return money >= expectedSum;
    }

    public long getClientIdByName(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where name='" + name + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        Long id = result.getLong("id");
        result.close();
        stmt.close();
        return id;
    }

    public BankClient getClientByName(String nameCur) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from bank_client where name='" + nameCur + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        Long id = result.getLong("id");
        String name = result.getString("name");
        String password = result.getString("password");
        Long money = Long.parseLong(result.getString("money"));
        result.close();
        stmt.close();
        return new BankClient(id, name, password, money);

    }

    public void addClient(BankClient client) throws SQLException {


        PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_MODEL);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getPassword());
        preparedStatement.setLong(3, (Long) client.getMoney());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        //  stmt.execute("create table if not exists bank_client (id bigint auto_increment, name varchar(256), password varchar(256), money bigint, primary key (id))");
        stmt.execute("create table if not exists bank_client (id SERIAL PRIMARY KEY , name varchar(256), password varchar(256), money bigint);\n");

        stmt.close();
    }

    public void dropTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS bank_client");
        stmt.close();
    }


    //MyMethod

    public void deleteClient(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BY_NAME);
        preparedStatement.setString(1, name);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
