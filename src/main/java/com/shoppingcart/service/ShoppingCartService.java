package com.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.shoppingcart.product.Product;

public class ShoppingCartService implements ShoppingCart {

	private List<Product> products = new ArrayList<Product>();
	
	public void addProductToCart(Product productToAdd) {
		if (null != productToAdd) {
			products.add(productToAdd);
		}
	}

	public void addProductsToCart(List<Product> productsToAdd) {
		if (null == products) {
			products = new ArrayList<Product>();
		}

		if (null != productsToAdd) {
			products.addAll(productsToAdd);
		}
		
	}

	public List<Product> getProducts() {
		return products;
	}

	public Double calculateCartValue() {
		Double totalPrice = products.stream().collect(Collectors.summingDouble(Product::getPrice));
        return totalPrice;
	}

	@Override
	public void clearCart() {
		products = new ArrayList<Product>();
	}

}
