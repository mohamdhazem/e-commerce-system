package Orders;

import Interfaces.IShippingProduct;
import Interfaces.IShippingService;
import Products.Product;
import Products.ShippingProduct;

import java.util.Map;

public class ShippingService implements IShippingService {

    private final Map<IShippingProduct, Integer> shippingProducts;
    double shippingPercentage = 0.03;
    int TotalWeight;

    public ShippingService(Map<IShippingProduct,Integer> shippingProducts){
        this.shippingProducts = shippingProducts;
    }

    @Override
    public void PrintDetails() {

        TotalWeight = 0;

        System.out.println("** Shipment notice **");

        for (Map.Entry<IShippingProduct, Integer> entry : shippingProducts.entrySet())
        {
            System.out.print(entry.getValue()+"x ");
            System.out.printf("%-20s %5.0fg%n",entry.getKey().GetName(),entry.getKey().GetWeight());
            TotalWeight += (int) (entry.getKey().GetWeight() * entry.getValue());
        }

        System.out.println("Total package weight "+TotalWeight/1000.0+"kg\n");
    }

    @Override
    public int ShippingCost() {

        TotalWeight = 0;

        for (Map.Entry<IShippingProduct, Integer> entry : shippingProducts.entrySet())
        {
            TotalWeight += (int) (entry.getKey().GetWeight()* entry.getValue());
        }

        return (int) (TotalWeight * shippingPercentage);
    }
}
