package com.shoppingcart.factory;

import org.junit.Assert;
import org.junit.Test;

import com.shoppingcart.product.Product;
import com.shoppingcart.product.ProductType;

public class ProductFactoryTest {

	@Test
	public void testGetProduct() {
		
		Product apple = ProductFactory.getProduct(ProductType.APPLE, 0.6);
		Assert.assertEquals("APPLE", apple.getName());
		Assert.assertEquals(0.6, apple.getPrice(), 0.0);
		
		Product orange = ProductFactory.getProduct(ProductType.ORANGE, 0.25);
		Assert.assertEquals("ORANGE", orange.getName());
		Assert.assertEquals(0.25, orange.getPrice(), 0.0);
	}

}
