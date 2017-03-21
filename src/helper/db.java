package helper;

import javax.activation.DataSource;
import java.sql.*;
import java.util.HashMap;

/**
 * Created by lookitsmarc on 21/03/2017.
 */
public class db {
    // Define class property
    protected Connection connection;
    protected DataSource dataSource;
    protected String     wsUrl;
    protected javax.servlet.http.HttpServletResponse resp;

    // Import the JDBC mysql driver

    // Define the Database connection credentials
    protected final String username = "root";
    protected final String password = "root";

    // Instantiate a new DB create a connection toward the database using the given URI

    /**
     * Db - Constructor
     * @param url
     */
    public db(String url, javax.servlet.http.HttpServletResponse response){
        this.wsUrl = url;
        this.resp = response;
    }

    /**
     * DoConnection
     * Init a connection with the database
     */
    public void doConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection(this.wsUrl+"?user="+this.username+"&password="+this.password);
        } catch (Exception e) {
            helper.logger(e.getMessage(), resp);
        }
    }

    /**
     * Select
     * @return Map
     */
    public Boolean selectPerson(HashMap<String, String> data){
        HashMap<String, String> dataMap = new HashMap<String, String>();

        try {
            String username = helper.getMapData(data, "username");
            String pwd = helper.getMapData(data, "password");

            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Persons WHERE username = ? AND password = ? ");
            stmt.setString(1, username);
            stmt.setString(2, pwd);

            ResultSet res = stmt.executeQuery();

            if (!res.next()){
                return false;
            }
        } catch (Exception e) {
            helper.logger(e.toString(), resp);
        }

        return true;
    }

    /**
     * Insert
     *      Insert a user based on the data.
     *      If the request failed then it will thrown an error and log in the body
     * @param data
     * @return Boolean
     */
    public Boolean insert(HashMap data){
        try {
            // get the data to the hasmap
            String username = helper.getMapData(data, "username");
            String pwd = helper.getMapData(data, "password");

            PreparedStatement prepared = this.connection.prepareStatement("INSERT INTO Persons (username, password) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, username);
            prepared.setString(2, pwd);
            prepared.executeUpdate();
           // ResultSet res = prepared.getGeneratedKeys();
        } catch (Exception e){
            helper.logger(e.getMessage(), resp);
        }

        return true;
    }
}
