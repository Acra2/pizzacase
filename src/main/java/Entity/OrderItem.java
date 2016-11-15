package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sander on 27-10-2016.
 */
@Data
@Entity
@NoArgsConstructor
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id;

    @OneToOne
    private Pizza pizza;
    private Integer quantity;

    @java.beans.ConstructorProperties({"pizza", "quantity"})
    public OrderItem(Pizza pizza, Integer quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }
}
