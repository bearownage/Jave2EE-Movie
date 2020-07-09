package usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MovieDao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO MOVIES" + " (name, , rating) VALUES " + " (?, ?, ?)";
    
    private static final String SELECT_MOVIE_BY_NAME = "select name,rating from movies where id=?;";
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
