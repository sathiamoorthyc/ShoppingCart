package com.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shoppingcart.factory.ProductFactory;
import com.shoppingcart.product.Product;
import com.shoppingcart.product.ProductType;

public class ShoppingCartServiceTest {

	ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCartService();
	}

	@Test
	public void testAddProductToCart() {
		Product apple = ProductFactory.getProduct(ProductType.APPLE, 0.6);
		shoppingCart.addProductToCart(apple);

		Product orange = ProductFactory.getProduct(ProductType.ORANGE, 0.25);
		shoppingCart.addProductToCart(orange);

		assertEquals(2, shoppingCart.getProducts().size());
	}

	@Test
	public void testAddProductsToCart() {
		List<Product> products = new ArrayList<Product>();

		Product apple = ProductFactory.getProduct(ProductType.APPLE, 0.6);
		products.add(apple);
		products.add(apple);
		Product orange = ProductFactory.getProduct(ProductType.ORANGE, 0.25);
		products.add(orange);

		shoppingCart.addProductsToCart(products);

		assertEquals(3, shoppingCart.getProducts().size());
	}

	@Test
	public void testCalculateCartValueWithNoProducts() {
		shoppingCart.clearCart();

		assertEquals(0.0, shoppingCart.calculateCartValue(), 0.0);
	}

	@Test
	public void testCalculateCartValueWithFewProducts() {
		shoppingCart.clearCart();

		List<Product> products = new ArrayList<Product>();

		Product apple = ProductFactory.getProduct(ProductType.APPLE, 0.6);
		products.add(apple);
		products.add(apple);
		Product orange = ProductFactory.getProduct(ProductType.ORANGE, 0.25);
		products.add(orange);

		shoppingCart.addProductsToCart(products);
		assertEquals(1.45, shoppingCart.calculateCartValue(), 0.0);
	}
	
	@Test
	public void testClearCart() {
		shoppingCart.clearCart();

		assertEquals(0, shoppingCart.getProducts().size());
	}
	

}
