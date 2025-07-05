package ProductTypes;

import Interfaces.IExpirableProduct;

public class ExpirableProduct extends Product implements IExpirableProduct {
    private boolean IsExpired = false;

    public ExpirableProduct(String Name, int Price, int StockQuantity) {
        super(Name, Price, StockQuantity);
    }

    @Override
    public boolean HasExpiry() {
        return true;
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
