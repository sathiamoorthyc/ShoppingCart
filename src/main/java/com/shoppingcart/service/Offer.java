package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.product.Product;

@FunctionalInterface
public interface Offer {
	Double applyOffer(List<Product> products, String productName);
}