package helper;

import javax.activation.DataSource;
import java.sql.Connection;

/**
 * Created by lookitsmarc on 21/03/2017.
 */
public class db {
    // Define class property
    protected Connection connection;
    protected DataSource dataSource;
    protected String     wsUrl;

    // Import the JDBC mysql driver

    // Define the Database connection credentials
    protected final String username = "root";
    protected final String password = "root";

    // Instantiate a new DB create a connection toward the database using the given URI
    public db(String url){
        this.wsUrl = url;
    }

    public void doConnection(){
       // Class.forName("com.mysql.jdbc.Driver");

        try {

        } catch (Exception e) {

        }
    }
}
