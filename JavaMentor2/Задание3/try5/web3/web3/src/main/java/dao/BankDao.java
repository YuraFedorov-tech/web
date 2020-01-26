package dao;

import exception.DBException;
import model.BankClient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/*
 *@Data 08.01.2020
 *@autor Fedorov Yuri
 *@project Web3
 *
 */
public interface BankDao {
    public List<BankClient> getAllBankClient() throws SQLException;

    public boolean validateClient(String name, String password) throws SQLException;
    public void updateClientsMoney(String name, String password, Long transactValue) throws SQLException, DBException;

    public BankClient getClientById(long id)throws SQLException;

    public boolean isClientHasSum(String name, Long expectedSum) throws SQLException;

    public long getClientIdByName(String name) throws SQLException ;

    public BankClient getClientByName(String name) throws SQLException;

    public void addClient(BankClient client)throws SQLException;

    public void createTable() throws SQLException ;

    public void dropTable() throws SQLException ;

    void deleteClient(String name) throws SQLException;
}
