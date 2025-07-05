package Orders;

import Customers.Customer;
import Interfaces.IShippableProduct;
import Interfaces.IShippingService;
import ProductTypes.Expirable_Shippable_Product;
import ProductTypes.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final IShippingService shippingService;
    private Map<IShippableProduct, Integer> shippingProducts = new HashMap<IShippableProduct, Integer>();
    int SubTotal;
    int ShippingCost;
    int Amount;

    public Order(IShippingService shippingService){
        this.shippingService = shippingService;
    }

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
                if (entry.getKey() instanceof IShippableProduct shippingProduct)
                    shippingProducts.put(shippingProduct,entry.getValue());

                if (entry.getKey() instanceof Expirable_Shippable_Product expirableShippingProduct)
                    shippingProducts.put(expirableShippingProduct,entry.getValue());
            }

            SubTotal += entry.getKey().GetPrice() * entry.getValue();
        }

        ShippingCost = shippingService.ShippingCost(shippingProducts);
        Amount = SubTotal + ShippingCost;

        if (customer.GetBalance() < Amount){
            System.out.println("Error, Customer's balance is insufficient");
            return;
        }

        customer.SetBalance(customer.GetBalance() - Amount);

        // Print ShippingCost Details
        shippingService.PrintDetails(shippingProducts);
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
