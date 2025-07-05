package Products;

import Interfaces.IShippingProduct;

public class ShippingProduct extends Product implements IShippingProduct {

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
