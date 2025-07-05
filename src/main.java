import Interfaces.IShippingProduct;
import Orders.Cart;
import Orders.Customer;
import Orders.Order;
import Products.Expirable_Shipping_Product;
import Products.Product;
import Products.ShippingProduct;

public class main {
    public static void main(String[] args) {

        Product cheese = new Expirable_Shipping_Product("Cheese",200,50,200);
        Product tv = new ShippingProduct("Samsung",10000,5,3000);
        Product scratchCard = new Product("scratchCard_1",20,100);


        //************************** Success Example **************************//
        Customer customer = new Customer(100000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(tv, 4);
        cart.add(scratchCard, 1);

        Order order = new Order();
        order.Checkout(customer, cart);

        //************************** Product Out Of Stock Example **************************//
//        Customer customer = new Customer(100000);
//
//        Cart cart = new Cart();
//        cart.add(cheese, 1000);
//        cart.add(tv, 4);
//        cart.add(scratchCard, 1);
//
//        Order order = new Order();
//        order.Checkout(customer, cart);

        //************************** Customer's balance is insufficient Example **************************//
//        Customer customer = new Customer(1000);
//
//        Cart cart = new Cart();
//        cart.add(cheese, 10);
//        cart.add(tv, 4);
//        cart.add(scratchCard, 1);
//
//        Order order = new Order();
//        order.Checkout(customer, cart);

        //************************** Cart is Empty Example **************************//
//        Customer customer = new Customer(1000);
//
//        Cart cart = new Cart();
//
//        Order order = new Order();
//        order.Checkout(customer, cart);
    }
}

