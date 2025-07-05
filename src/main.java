import Customers.Customer;
import Interfaces.IShippingService;
import Orders.Cart;
import Orders.Order;
import Orders.ShippingService;
import ProductSamples.Cheese;
import ProductSamples.ScratchCard;
import ProductSamples.Tv;
import ProductTypes.Expirable_Shippable_Product;
import ProductTypes.Product;
import ProductTypes.ShippingProduct;

public class main {
    public static void main(String[] args) {

        Product cheese = new Cheese("Mozzarella cheese",200,50,500);
        Product tv = new Tv("Samsung",10000,5,3000);
        Product scratchCard = new ScratchCard("scratchCard_1",20,100);

        // Shipping Service that used in order can be changed here without effect on anything (Loosely coupled)
        IShippingService shippingService = new ShippingService();


        //************************** Success Example **************************//
        Customer customer = new Customer(100000);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(tv, 4);
        cart.add(scratchCard, 1);


        Order order = new Order(shippingService);
        order.Checkout(customer, cart);

        //************************** Product Out Of Stock Example **************************//
//        Customer customer = new Customer(100000);
//
//        Cart cart = new Cart();
//        cart.add(cheese, 1000);
//        cart.add(tv, 4);
//        cart.add(scratchCard, 1);
//
//        Order order = new Order(shippingService);
//        order.Checkout(customer, cart);

        //************************** Customers.Customer's balance is insufficient Example **************************//
//        Customer customer = new Customer(1000);
//
//        Cart cart = new Cart();
//        cart.add(cheese, 10);
//        cart.add(tv, 4);
//        cart.add(scratchCard, 1);
//
//        Order order = new Order(shippingService);
//        order.Checkout(customer, cart);

        //************************** Cart is Empty Example **************************//
//        Customer customer = new Customer(1000);
//
//        Cart cart = new Cart();
//
//        Order order = new Order(shippingService);
//        order.Checkout(customer, cart);
    }
}

