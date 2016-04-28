package com.shoppingcart.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.shoppingcart.factory.ProductFactory;
import com.shoppingcart.product.Product;
import com.shoppingcart.product.ProductType;

public class CheckoutServiceTest {

	ShoppingCart shoppingCart;
	
	@Before
	public void setUp(){
		shoppingCart = new ShoppingCartService();
	}
	
	@Test
	public void testCheckoutWithOneAppleAndOneOrange() {
		System.out.println("Running testCheckoutWithOneAppleAndOneOrange");
		Product apple = ProductFactory.getProduct(ProductType.APPLE, 0.6 );
		shoppingCart.addProductToCart(apple);
		
		Product orange = ProductFactory.getProduct(ProductType.ORANGE, 0.25);
		shoppingCart.addProductToCart(orange);
		
		double billAmount = CheckoutService.checkout(shoppingCart);
		Assert.assertEquals(0.85, billAmount,0.0);
	}
	
	@Test
	public void testCheckoutWithoutAnyProducts() {
		System.out.println("Running testCheckoutWithoutAnyProducts");
		shoppingCart.clearCart();
		double billAmount = CheckoutService.checkout(shoppingCart);
		Assert.assertEquals(0.0, billAmount,0.0);
	}
	
	@Test
	public void testCheckoutWithFiveApples() {
		System.out.println("Running testCheckoutWithFiveApples");
		shoppingCart.clearCart();
		Product apple = ProductFactory.getProduct(ProductType.APPLE, 0.6 );
		shoppingCart.addProductToCart(apple);
		shoppingCart.addProductToCart(apple);
		shoppingCart.addProductToCart(apple);
		shoppingCart.addProductToCart(apple);
		shoppingCart.addProductToCart(apple);
		
		double billAmount = CheckoutService.checkout(shoppingCart);
		Assert.assertEquals(3.0, billAmount,0.0);
	}

	@Test
	public void testCheckoutWithFiveOranges() {
		System.out.println("Running testCheckoutWithFiveOranges");
		shoppingCart.clearCart();
		Product orange = ProductFactory.getProduct(ProductType.ORANGE, 0.25 );
		shoppingCart.addProductToCart(orange);
		shoppingCart.addProductToCart(orange);
		shoppingCart.addProductToCart(orange);
		shoppingCart.addProductToCart(orange);
		shoppingCart.addProductToCart(orange);
		
		double billAmount = CheckoutService.checkout(shoppingCart);
		Assert.assertEquals(1.25, billAmount,0.0);
	}

}
