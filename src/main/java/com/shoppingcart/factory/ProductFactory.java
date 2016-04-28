package com.shoppingcart.factory;

import com.shoppingcart.product.Apple;
import com.shoppingcart.product.Orange;
import com.shoppingcart.product.Product;
import com.shoppingcart.product.ProductType;

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
}
