package Entity;

import interceptors.MyInterceptorBinding;
import interceptors.TestInterceptor;
import lombok.Data;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sander on 1-11-2016.
 */
@Stateful
@Interceptors(TestInterceptor.class)
//@MyInterceptorBinding
@Data
public class ShoppingCart implements Serializable {

    Map<Integer,OrderItem> items =  new HashMap<Integer, OrderItem>();

    public Integer getQuantityForItem(Integer id){
        if (items.containsKey(id)){
            return items.get(id).getQuantity();
        }else{
            return 0;
        }
    }

    public Integer getSize(){
        int x =0;
        for (OrderItem item:items.values() ) {
            x += item.getQuantity();
        }
        return x;
    }
    public Double totalPrice(){
        Double x =0.0;
        for (OrderItem item:items.values() ) {
            x += item.getQuantity() * item.getPizza().getPrice();
        }
        return x;
    }

    public List<Pizza> getPizzas(){
        List<Pizza> pizzas = new ArrayList<Pizza>();
        for (OrderItem item:items.values() ) {
            pizzas.add(item.getPizza());
        }
        return pizzas;
    }

    public void addToShoppingCard(Pizza pizza){
        if (items.containsKey(pizza.getId())){
            items.get(pizza.getId()).setQuantity(items.get(pizza.getId()).getQuantity()+1);
        }else{
            items.put(pizza.getId(), new OrderItem(pizza, 1));
        }
    }
    public void removeFromShoppingCard(Pizza pizza){
        if (items.containsKey(pizza.getId())){
            OrderItem item = items.get(pizza.getId());
            if (item.getQuantity() <= 1){
                items.remove(pizza.getId());
            }else{
                item.setQuantity(item.getQuantity()-1);
            }
        }
    }
}
