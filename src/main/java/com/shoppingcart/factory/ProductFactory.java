package com.shoppingcart.factory;

import com.shoppingcart.product.Apple;
import com.shoppingcart.product.Orange;
import com.shoppingcart.product.Product;
import com.shoppingcart.product.ProductType;
import com.shoppingcart.service.Offer;

public class ProductFactory {

	public static Product getProduct(ProductType type, Double price) {

		switch (type) {

		case APPLE:
			return new Apple(type.name(), price);

		case ORANGE:
			return new Orange(type.name(), price);

		default:
			return null;
		}
	}

	public static Product getProduct(ProductType type, Double price, Offer offer) {

		switch (type) {

		case APPLE:
			return new Apple(type.name(), price, offer);

		case ORANGE:
			return new Orange(type.name(), price, offer);

		default:
			return null;
		}
	}
}
