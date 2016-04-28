package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.product.Product;

public interface ShoppingCart {

	public void addProductToCart(Product product) ;
	public void addProductsToCart(List<Product> products) ;
	public List<Product> getProducts() ;
	public void clearCart();
	public Double calculateCartValue();
	
}
