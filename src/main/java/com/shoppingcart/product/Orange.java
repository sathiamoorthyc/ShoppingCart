package com.shoppingcart.product;

import com.shoppingcart.service.Offer;

public class Orange extends Product{

	public Orange(String name, Double price) {
		super(name, price);
	}

    public Orange(String name, Double price, Offer offer) {
        super(name, price, offer);
    }

}
