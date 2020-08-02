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
	
	private final static String SELECT_QUERY_ITEMS = "SELECT * FROM tbl_product WHERE name LIKE ?";
	
	private final static String ADD_QUERY_ITEM_TO_CART = "SELECT * FROM tbl_product WHERE id = ?";
	
	private List<Item> checkOutItems = new ArrayList<>();

    // select users
	public List<Item> selectQueryItems(String query) {
    	List<Item> items = new ArrayList<>();
    	//Establish connection
    	try (Connection connection = UtilDao.getConnection();
    			//Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_ITEMS)) {
    		//Execute or update query
    		preparedStatement.setString(1, "%" + query + "%");
    		System.out.println(preparedStatement);

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
    
    public void addItemToCart(int getID) {
    	//Establish connection
    	try (Connection connection = UtilDao.getConnection();
    			//Create a statement using connection object
    			PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY_ITEM_TO_CART)) {
    		preparedStatement.setInt(1, getID);

    		System.out.println(preparedStatement);
    		//Execute or update query
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		
    		// Process the ResultSet Object
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String name = rs.getString("name");
    			String image = rs.getString("image");
    			Double price = rs.getDouble("price");
    			checkOutItems.add(new Item(id, name, image, price));
    			}
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println(checkOutItems.size());
    }
}
