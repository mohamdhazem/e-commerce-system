package Interfaces;

import Orders.Cart;

import java.util.Map;

public interface IShippingService {
    public void PrintDetails(Map<IShippableProduct,Integer> shippingProducts);
    public int ShippingCost(Map<IShippableProduct,Integer> shippingProducts);
}
