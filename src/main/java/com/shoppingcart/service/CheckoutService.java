package com.shoppingcart.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.shoppingcart.product.Product;
import com.shoppingcart.product.ProductType;


public class CheckoutService {

	public static double checkout(ShoppingCart shoppingCart) {
		double billAmount = shoppingCart.calculateCartValue();
		System.out.println("Price without any offers: "+billAmount);
		
		Function<ShoppingCart, Double> offerFunction = CheckoutService::applyDiscount;
		
		billAmount = billAmount - offerFunction.apply(shoppingCart);
        System.out.println("Final price: " + billAmount + "\n");

		return billAmount;
	}
	
    public static Double applyDiscount(ShoppingCart cart) {
        Double finalDis = 0.0D;
      
        System.out.println("Calculating discounts...");
        List<Product> productsWithOffer = cart.getProducts().stream().filter(p -> p.getOffer() != null)
                .collect(Collectors.toList());
        System.out.println("Product with offer: " +  productsWithOffer.size());
       
        if (productsWithOffer != null && productsWithOffer.size()>0) {
            for (ProductType pType : ProductType.values()) {
                System.out.println("Calculating discounts for: " + pType.name());
                List<Product> products = productsWithOffer.stream()
                        .filter(p -> p.getName().equalsIgnoreCase(pType.name())).collect(Collectors.toList());
                
                Double discountAmt = 0.0;
                if(null != products && products.size() > 0){
                	discountAmt = products.get(0).getOffer().applyOffer(products, pType.name());
                }
                
                finalDis = discountAmt + finalDis;
            }
        }
        System.out.println("Final Discount- " + finalDis);
        return finalDis;
    }

}
