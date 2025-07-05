package Orders;

import Products.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    public Map<Product, Integer> productsMap = new HashMap<Product, Integer>();

    public void add(Product product, int quantity){
        productsMap.merge(product, quantity, Integer::sum);
    }
}
