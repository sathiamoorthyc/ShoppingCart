package com.shoppingcart.service;

import java.util.List;
import java.util.stream.Collectors;

import com.shoppingcart.product.Product;

public class OfferService {

    public Offer applyTwoForOneOffer = new Offer() {

        @Override
        public  final Double applyOffer(List<Product> productList, String productName) {
            Double discountAmout = 0.0D;
            List<Product> products = productList.stream().filter(product -> product.getName().equalsIgnoreCase(productName))
                    .collect(Collectors.toList());
            System.out.println("Number of  " + productName +" " +  products.size());
            discountAmout = (products.size() / 2) * products.get(0).getPrice();
            System.out.println("Discount Amount: " + discountAmout);
            return discountAmout;
        }

    };
    
    public final Offer applyThreeForTwoOffer = new Offer() {
        @Override
        public Double applyOffer(List<Product> productList, String productName) {
            Double discountAmout = 0.0D;
            List<Product> products = productList.stream().filter(product -> product.getName().equalsIgnoreCase(productName))
                    .collect(Collectors.toList());
            System.out.println("Number of  " + productName + " " + products.size());
            discountAmout = (products.size() / 3) * products.get(0).getPrice();
            System.out.println("Discount Amount: " + discountAmout);
            return discountAmout;
        }
    };

}
