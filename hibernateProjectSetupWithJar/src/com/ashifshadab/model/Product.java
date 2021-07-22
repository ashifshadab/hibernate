package com.ashifshadab.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	
	private String sku;
	private String name;
	private BigDecimal price;
	private Seller seller;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", name=" + name + ", price=" + price + ", seller=" + seller + "]";
	}

}
