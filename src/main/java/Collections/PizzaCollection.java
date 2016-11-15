package Collections;

import Entity.Pizza;
import Service.PizzaService;
import lombok.Data;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sander on 27-10-2016.
 */
@Data
@Model
public class PizzaCollection {
    private PizzaService pizzaService;

    public PizzaCollection(){
        pizzaService = new PizzaService();
    }

    public Pizza getPizzaById(Integer id){
        List<Pizza> pizzas = pizzaService.getPizzas();
        return pizzas.stream().filter(Pizza -> Pizza.getId() == id).findFirst().get();
    }
}
