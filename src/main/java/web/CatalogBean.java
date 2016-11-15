package web;

import Entity.Pizza;
import Service.PizzaService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TransferQueue;

/**
 * Created by Sander on 27-10-2016.
 */
@Data
@Stateless
@Named
public class CatalogBean implements Serializable {

    @Inject
    private PizzaService pizzaService;

//    @EJB
//    private TestSingleton singleton;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct called");
        //System.out.println(singleton.getString());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy called");
    }

    public List<Pizza> getPizzas() {
        return pizzaService.getPizzas();
    }

    @Schedule(second = "*/10", minute = "*", hour = "*")
    private void process() {
        Future<String> futurePizzas = getPizzaString();

        String resultString = "test String";
        try {
            System.out.println("Wait for pizzas");
            resultString = futurePizzas.get();
            System.out.println("Pizzas deliverd");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(resultString);
    }

    public Future<String> getPizzaString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pizza pizza : pizzaService.getPizzas()){
            if (stringBuilder.length() > 0)
                stringBuilder.append(", ");
            stringBuilder.append(pizza.getName());
        }
        System.out.println("Pizzas ready");

        return new AsyncResult<String>(stringBuilder.toString());
        // return new AsyncResult<String>(stringBuilder.toString());
    }
}
