package model;

public class Product {
	private int id;
	private int categoryId;
	private int authorId;
	private int publisherId;
	private String isbn;
	private String title;
	private short pages;
	private short year;
	private String weight;
	private String size;
	private String content;
	private String imageURL;
	private String description;
	private int price;
	public Product(int id, int categoryId, int authorId, int publisherId, String isbn, String title, short pages,
			short year, String weight, String size, String content, String imageURL, String description, int price) {
		this.id = id;
		this.categoryId = categoryId;
		this.authorId = authorId;
		this.publisherId = publisherId;
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.year = year;
		this.weight = weight;
		this.size = size;
		this.content = content;
		this.imageURL = imageURL;
		this.description = description;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public short getPages() {
		return pages;
	}
	public void setPages(short pages) {
		this.pages = pages;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
