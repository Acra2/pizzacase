package Service;

import Entity.Order;
import Entity.Pizza;
import greeting.EventReceiver;
import greeting.EventSender;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sander on 1-11-2016.
 */
@Model
public class OrderService {
    protected EntityManager entityManager;

    public OrderService(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PizzaService");
        entityManager =  emf.createEntityManager();
    }

    public List<Order> getOrders() {
        TypedQuery<Order> query = entityManager.createQuery(
                "SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    public void createOrder(Order order){
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }
}
