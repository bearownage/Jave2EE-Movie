package usermanagement.model;

public class Item {

	private int id;
	private String name;
	private String image;
	private Double price;
	
	public Item(int id, String name, String image, Double price) {
		super();
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
