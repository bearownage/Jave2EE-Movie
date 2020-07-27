package usermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usermanagement.model.Item;
import usermanagement.model.User;

public class CartDao {
	
	private final static String SELECT_ALL_ITEMS = "SELECT * FROM tbl_product ORDER BY id ASC";
    // select users
    public List<Item> selectAllItems() {
    	List<Item> items = new ArrayList<>();
    	//Establish connection
    	try (Connection connection = UtilDao.getConnection();
    			//Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEMS)) {
    		System.out.println(preparedStatement);
    		//Execute or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		
    		// Process the ResultSet Object
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String name = rs.getString("name");
    			String image = rs.getString("image");
    			Double price = rs.getDouble("price");
    			items.add(new Item(id, name, image, price));
    			}
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return items;
    }
}
