package Orders;

public class Customer {
    private int balance;

    public Customer(int Balance){
        this.balance = Balance;
    }

    public void SetBalance(int balance){
        this.balance = balance;
    }

    public int GetBalance(){
        return this.balance;
    }
}
