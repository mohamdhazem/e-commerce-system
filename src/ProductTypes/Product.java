package ProductTypes;

public class Product{

    private String name;
    private int price;
    private int stockQuantity;

    public Product (String Name, int Price ,int StockQuantity){
        this.name = Name;
        this.price = Price;
        this.stockQuantity = StockQuantity;
    }

    public String GetName() {
        return this.name;
    }

    public int GetPrice(){
        return this.price;
    }

    public int GetStockQuantity(){
        return this.stockQuantity;
    }

    public void SetStockQuantity(int Quantity){
        this.stockQuantity = Quantity;
    }

    public boolean HasWeight() {
        return false;
    }

    public Double GetWeight() {
        return 0.0;
    }

    public boolean HasExpiry() {
        return false;
    }

    public boolean IsExpired() {
        return false;
    }

}

