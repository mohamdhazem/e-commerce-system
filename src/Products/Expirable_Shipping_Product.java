package Products;

import Interfaces.IExpirableProduct;
import Interfaces.IShippingProduct;

public class Expirable_Shipping_Product extends Product implements IShippingProduct, IExpirableProduct {
    private final double weight;
    private boolean IsExpired = false;

    public Expirable_Shipping_Product(String Name, int Price, int StockQuantity, double Weight) {
        super(Name, Price, StockQuantity);
        weight = Weight;
    }

    @Override
    public boolean HasWeight() {
        return true;
    }

    @Override
    public Double GetWeight() {
        return this.weight;
    }

    @Override
    public boolean IsExpired() {
        return IsExpired;
    }

    @Override
    public void ExpireIt() {
        this.IsExpired = true;
    }
}
