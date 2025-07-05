package ProductTypes;

import Interfaces.IShippableProduct;

public class ShippingProduct extends Product implements IShippableProduct {

    private final Double weight;

    public ShippingProduct (String Name, int Price ,int StockQuantity ,double Weight){
        super(Name,Price,StockQuantity);
        this.weight = Weight;
    }

    @Override
    public boolean HasWeight() {
        return true;
    }

    @Override
    public Double GetWeight() {
        return this.weight;
    }

}
