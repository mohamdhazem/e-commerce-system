package Orders;

import Interfaces.IShippingProduct;
import Interfaces.IShippingService;
import Products.Expirable_Shipping_Product;
import Products.Product;
import Products.ShippingProduct;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private IShippingService shippingService;
    private Map<IShippingProduct, Integer> shippingProducts = new HashMap<IShippingProduct, Integer>();
    int SubTotal;
    int ShippingCost;
    int Amount;

    
    public void Checkout(Customer customer, Cart cart){

        if (cart.productsMap.isEmpty()){
            System.out.println("Error, Cart is Empty");
            return;
        }

        for (Map.Entry<Product, Integer> entry : cart.productsMap.entrySet()){
            if (entry.getKey().HasExpiry() && entry.getKey().IsExpired()){
                System.out.println("Error, "+entry.getKey().GetName() +" is Expired");
                return;
            }

            if (entry.getKey().GetStockQuantity() < entry.getValue()){
                System.out.println("Error, "+entry.getKey().GetName() +" is out of stock");
                return;
            }

            if (entry.getKey().HasWeight())
            {
                if (entry.getKey() instanceof IShippingProduct shippingProduct)
                    shippingProducts.put(shippingProduct,entry.getValue());

                if (entry.getKey() instanceof Expirable_Shipping_Product expirableShippingProduct)
                    shippingProducts.put(expirableShippingProduct,entry.getValue());
            }

            SubTotal += entry.getKey().GetPrice() * entry.getValue();
        }

        shippingService = new ShippingService(shippingProducts);
        ShippingCost = shippingService.ShippingCost();
        Amount = SubTotal + ShippingCost;

        if (customer.GetBalance() < Amount){
            System.out.println("Error, Customer's balance is insufficient");
            return;
        }

        customer.SetBalance(customer.GetBalance() - Amount);

        // Print ShippingCost Details
        shippingService.PrintDetails();
        // Print Checkout Receipt
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.productsMap.entrySet())
        {
            System.out.print(entry.getValue()+"x ");
            System.out.printf("%-20s %5d%n", entry.getKey().GetName() , entry.getKey().GetPrice());
            entry.getKey().SetStockQuantity(entry.getKey().GetStockQuantity() - entry.getValue());
        }

        System.out.println("-----------------------------");
        System.out.printf("%-20s %8d%n","Subtotal", SubTotal);
        System.out.printf("%-20s %8d%n","ShippingCost", ShippingCost);
        System.out.printf("%-20s %8d%n","Amount", Amount);
        System.out.printf("%-20s %8d%n","NewBalance",customer.GetBalance());


    }
}
