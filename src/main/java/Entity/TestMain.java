package Entity;

import Service.OrderService;
import Service.PizzaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sander on 31-10-2016.
 */
public class TestMain {
    public static void main(String[] args) {
        PizzaService pizzaService = new PizzaService();
        OrderService orderService = new OrderService();

        Pizza p = new Pizza("Salami",10.30);
        p = pizzaService.createPizza(p);
        pizzaService.createPizza(new Pizza("hawai",9.30));
        pizzaService.createPizza(new Pizza("prosquito",8.30));

        HashMap<Integer, OrderItem> orderItems = new HashMap<>();
        orderItems.put(1, new OrderItem(p, 5));
        Customer sander = new Customer("Sander");
        Order order = new Order(orderItems, sander);
        orderService.createOrder(order);
        Order order2 = new Order(orderItems, sander);
        orderService.createOrder(order2);

        System.out.println("pizzas: "+pizzaService.getPizzas().size());
        System.out.println("orders: "+orderService.getOrders().get(0).getItems().size());
        System.out.println("Customerid: "+orderService.getOrders().get(0).getCustomer().getId());
        List<Pizza> pizzas = pizzaService.getPizzas();
    }
}
