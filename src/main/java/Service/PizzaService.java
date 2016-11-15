package Service;

import Entity.Pizza;

import javax.ejb.LocalBean;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sander on 31-10-2016.
 */
@Model
public class PizzaService {
    protected EntityManager entityManager;

    public PizzaService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaService");
        entityManager =  emf.createEntityManager();
    }

    public List<Pizza> getPizzas() {
        TypedQuery<Pizza> query = entityManager.createQuery(
                "SELECT p FROM Pizza p", Pizza.class);
        return query.getResultList();
    }

    public Pizza createPizza(Pizza pizza){
        entityManager.getTransaction().begin();
        entityManager.persist(pizza);
        entityManager.getTransaction().commit();
        return pizza;
    }

    public Pizza getPizzaById(Integer id){
        return getPizzas().stream().filter(Pizza -> Pizza.getId() == id).findFirst().get();
    }

}
