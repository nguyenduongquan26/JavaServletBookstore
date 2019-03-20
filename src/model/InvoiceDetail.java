package model;

public class InvoiceDetail {
private long invoiceId;
private int productId;
private String title;
private String imageUrl;
private int price;
private short quantity;
public InvoiceDetail(long invoiceId, int productId, int price, short quantity) {
	
	this.invoiceId = invoiceId;
	this.productId = productId;
	this.price = price;
	this.quantity = quantity;
}


public InvoiceDetail(long invoiceId, int productId, String title, String imageUrl, int price, short quantity) {
	this.invoiceId = invoiceId;
	this.productId = productId;
	this.title = title;
	this.imageUrl = imageUrl;
	this.price = price;
	this.quantity = quantity;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getImageUrl() {
	return imageUrl;
}


public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}


public long getInvoiceId() {
	return invoiceId;
}
public void setInvoiceId(long invoiceId) {
	this.invoiceId = invoiceId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public short getQuantity() {
	return quantity;
}
public void setQuantity(short quantity) {
	this.quantity = quantity;
}


}
