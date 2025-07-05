package Orders;

import Interfaces.IShippableProduct;
import Interfaces.IShippingService;

import java.util.Map;

public class ShippingService implements IShippingService {

    double shippingPercentage = 0.03;
    int TotalWeight;

    public ShippingService(){

    }

    @Override
    public void PrintDetails(Map<IShippableProduct,Integer> shippableProducts) {

        TotalWeight = 0;

        System.out.println("** Shipment notice **");

        for (Map.Entry<IShippableProduct, Integer> entry : shippableProducts.entrySet())
        {
            System.out.print(entry.getValue()+"x ");
            System.out.printf("%-20s %5.0fg%n",entry.getKey().GetName(),entry.getKey().GetWeight());
            TotalWeight += (int) (entry.getKey().GetWeight() * entry.getValue());
        }

        System.out.println("Total package weight "+TotalWeight/1000.0+"kg\n");
    }

    @Override
    public int ShippingCost(Map<IShippableProduct,Integer> shippableProducts) {

        TotalWeight = 0;

        for (Map.Entry<IShippableProduct, Integer> entry : shippableProducts.entrySet())
        {
            TotalWeight += (int) (entry.getKey().GetWeight()* entry.getValue());
        }

        return (int) (TotalWeight * shippingPercentage);
    }
}
