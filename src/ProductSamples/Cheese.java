package ProductSamples;

import ProductTypes.Expirable_Shippable_Product;

public class Cheese extends Expirable_Shippable_Product {

    public Cheese(String Name, int Price, int StockQuantity, double Weight)
    {
        super(Name,Price,StockQuantity,Weight);
    }

}
