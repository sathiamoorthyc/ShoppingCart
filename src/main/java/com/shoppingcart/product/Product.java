package com.shoppingcart.product;

import com.shoppingcart.service.Offer;

public abstract class Product {

	private String name;
	private Double price;
	private Offer offer;

    public Product(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Product(String name, Double price, Offer offer) {
        super();
        this.name = name;
        this.price = price;
        this.offer = offer;
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
}
