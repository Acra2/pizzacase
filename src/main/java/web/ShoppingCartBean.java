package web;

import Entity.Customer;
import Entity.Pizza;
import Entity.Order;
import Entity.ShoppingCart;
import Service.OrderService;
import Service.PizzaService;
import greeting.EventReceiver;
import greeting.EventSender;
import greeting.GreetingReceiver;
import greeting.GreetingSender;
import lombok.Getter;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 27-10-2016.
 */
@Named
@SessionScoped
public class ShoppingCartBean implements Serializable {
    @Inject
    private ShoppingCart cart;

    @Getter
    private Customer customer = new Customer("");

    @Inject
    private PizzaService pizzaService;

    @Inject
    private OrderService orderService;

    public Integer getQuantity(Integer itemId){
        return cart.getQuantityForItem(itemId);
    }

    public void addToCart(Integer itemId){
        Pizza pizza = pizzaService.getPizzaById(itemId);
        cart.addToShoppingCard(pizza);
    }
    public void removeFromCart(Integer itemId){
        Pizza pizza = pizzaService.getPizzaById(itemId);
        cart.removeFromShoppingCard(pizza);
    }

    public List<Pizza> getPizzas(){
        return cart.getPizzas();
    }

    public Integer getCartSize(){
        return cart.getSize();
    }

    public Double getTotalPrice(){
        return cart.totalPrice();
    }

    public void createOrder(){
        Order order = new Order(cart.getItems(), customer);
        orderService.createOrder(order);
        cart.getItems().clear();
    }
}
