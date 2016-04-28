package com.shoppingcart.product;

import com.shoppingcart.service.Offer;

public class Apple extends Product{

	public Apple(String name, Double price) {
		super(name, price);
	}

    public Apple(String name, Double price, Offer offer) {
        super(name, price, offer);
    }

}
