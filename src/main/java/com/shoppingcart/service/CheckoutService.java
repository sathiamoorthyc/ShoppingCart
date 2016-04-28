package com.shoppingcart.service;

public class CheckoutService {

	public static double checkout(ShoppingCart shoppingCart) {
		double billAmount = shoppingCart.calculateCartValue();
		System.out.println("Final bill amount: "+billAmount);
		return billAmount;
	}

}
