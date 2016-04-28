package com.shoppingcart.service;

import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

import com.shoppingcart.factory.ProductFactory;
import com.shoppingcart.product.ProductType;

public class OfferServiceTest {

	ShoppingCart shoppingCart;

	@Before
	public void setUp() {
		shoppingCart = new ShoppingCartService();
	}

	@Test
	public void test() {
		shoppingCart.addProductToCart(ProductFactory.getProduct(ProductType.APPLE, 0.60D, new OfferService().applyTwoForOneOffer));
		shoppingCart.addProductToCart(ProductFactory.getProduct(ProductType.APPLE, 0.60D, new OfferService().applyTwoForOneOffer));
		shoppingCart.addProductToCart(ProductFactory.getProduct(ProductType.ORANGE, 0.25D, new OfferService().applyThreeForTwoOffer));
		shoppingCart.addProductToCart(ProductFactory.getProduct(ProductType.ORANGE, 0.25, new OfferService().applyThreeForTwoOffer));
		shoppingCart.addProductToCart(ProductFactory.getProduct(ProductType.ORANGE, 0.25, new OfferService().applyThreeForTwoOffer));

		
		double billAmount = shoppingCart.calculateCartValue();
		System.out.println("Price without any offers: "+billAmount);
		
		Function<ShoppingCart, Double> offerFunction = CheckoutService::applyDiscount;
		
		billAmount = billAmount - offerFunction.apply(shoppingCart);
        System.out.println("Final price: " + billAmount );

	}
}
