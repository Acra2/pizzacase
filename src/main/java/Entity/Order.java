package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Sander on 27-10-2016.
 */
@Data
@Entity
@Table(name = "PizzaOrder")
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST)
    Map<Integer,OrderItem> items =  new HashMap<Integer, OrderItem>();

    public Order(Map<Integer, OrderItem> items, Customer customer) {
        this.items = items;
        this.customer = customer;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = items.entrySet().iterator();
        for (Integer key : items.keySet()) {
            if (stringBuilder.length() > 0 )
                stringBuilder.append(", ");
            stringBuilder.append(items.get(key).getQuantity() + " " + items.get(key).getPizza().getName());
        }
        return stringBuilder.toString();
    }
}
