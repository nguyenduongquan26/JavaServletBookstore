package model;

public class Cart {
	private int productId;
	private short quantity;
	private String title;
	private int price;
	private String imageURL;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public short getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	public void increaseQuantity(short val) {
		quantity += val;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Cart(int productId, short quantity, String title, int price, String imageURL) {
		this.productId = productId;
		this.quantity = quantity;
		this.title = title;
		this.price = price;
		this.imageURL = imageURL;
	}
	
	
}
