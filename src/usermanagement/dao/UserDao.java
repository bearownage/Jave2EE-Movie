package usermanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import usermanagement.model.User;

// This DAO class provides CRUD database operations for the table users in the database.
public class UserDao {
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";
    
    private static final String INSERT_USERS_SQL = "INSERT INTO USERS" + " (name, email, country) VALUES " + " (?, ?, ?)";
    
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id=?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?,country =? where id =?;";
    
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
    
    // Create or insert user
    public void insertUser(User user) throws SQLException {
    	try(Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
    		// Providing values for placeholders
    		preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
            //preparedStatement.setString(4, user.getPassword());
    		} catch (Exception e) {
    			e.printStackTrace();
    	}
    }
    // update user
    public boolean updateUser(User user) throws SQLException {
    	boolean rowUpdated = false;
    	try(Connection connection = getConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
        		// Providing values for placeholders
    			preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.setInt(4, user.getId());
                
                rowUpdated = preparedStatement.executeUpdate() > 0;
                //preparedStatement.setString(4, user.getPassword());
        		} catch (Exception e) {
        			e.printStackTrace();
        	}
    	
    	return rowUpdated;
    }
    // select user by id
    public User selectUser(int id) {
    	User user = null;
    	//Establish connection
    	try (Connection connection = getConnection();
    			//Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
    		preparedStatement.setInt(1, id);
    		System.out.println(preparedStatement);
    		//Execute or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		
    		// Process the ResultSet Object
    		while(rs.next()) {
    			String name = rs.getString("name");
    			String email = rs.getString("email");
    			String country = rs.getString("country");
    			user = new User(id, name, email, country);
    			}
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return user;
    }
    // select users
    public List<User> selectAllUsers() {
    	List<User> users = new ArrayList<>();
    	//Establish connection
    	try (Connection connection = getConnection();
    			//Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
    		System.out.println(preparedStatement);
    		//Execute or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		
    		// Process the ResultSet Object
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String name = rs.getString("name");
    			String email = rs.getString("email");
    			String country = rs.getString("country");
    			users.add(new User(id, name, email, country));
    			}
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return users;
    }
    
    // delete user
    public boolean deleteUser(int id) throws SQLException {
    	boolean rowDeleted;
    	try(Connection connection = getConnection(); 
    			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
    		preparedStatement.setInt(1, id);
    		rowDeleted = preparedStatement.executeUpdate() > 0;
    	}
    	return rowDeleted;
    }
    
    
}
