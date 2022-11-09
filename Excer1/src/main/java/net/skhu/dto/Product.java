package net.skhu.dto;

public class Product {
	String product;
	int category;
	String price;
	String quantity;


	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getPriceSum() {
		int result1=Integer.parseInt(price);
		int result2=Integer.parseInt(quantity);
		return result1*result2;
	}


}
