package web;

import Entity.Order;
import Entity.Pizza;
import Service.OrderService;
import Service.PizzaService;
import interceptors.TestInterceptor;
import lombok.Data;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 1-11-2016.
 */
@Data
@Stateful
@Named
@Interceptors(TestInterceptor.class)
public class OrderBean implements Serializable {
    @Inject
    private OrderService orderService;

    public List<Order> getOrders(){
        return orderService.getOrders();
    }
}
