package Connection;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 *@Data 09.01.2020
 *@autor Fedorov Yuri
 *@project Web3
 *
 */
public class ConnectionWhithDB {
    protected static Connection connection;


    private static synchronized Connection getConnection() {

        if (connection != null)
            return connection;
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.postgresql.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.append("jdbc:postgresql://").        //db type
                    append("localhost:").           //host name
                    append("5432/").                //port
                    append("bank_client").          //db name
                    append("user=postgres&").          //login
                    append("password=123");       //password
            System.out.println("URL: " + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return connection;
    }
}
