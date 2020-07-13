package usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import usermanagement.model.Movie;
import usermanagement.model.User;

public class MovieDao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";
    
    private static final String INSERT_MOVIES_SQL = "INSERT INTO MOVIES" + " (name, , rating) VALUES " + " (?, ?, ?)";
    
    private static final String SELECT_MOVIE_BY_NAME = "select name,rating,poster,director from movies where name=?;";
    
    /*
     * TODO
     * Make the GET Request to TMDB Api instead of loading from my sql database. 
     */
    
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
    
    // select movie by name
    public Movie selectMovie(String name) {
    	Movie movie = null;
    	//Establish connection
    	try (Connection connection = getConnection();
    			//Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_NAME)) {
    		preparedStatement.setString(1, name);
    		System.out.println(preparedStatement);
    		//Execute or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		
    		// Process the ResultSet Object
    		while(rs.next()) {
    			//String name = rs.getString("name");
    			//String email = rs.getString("email");
    			double rating = rs.getDouble("rating");
    			String poster = rs.getString("poster");
    			String director = rs.getString("director");
    			movie = new Movie(name, rating, poster, director);
    			}
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return movie;
    }
}
