package Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sander on 27-10-2016.
 */
@Data
@Entity
@NoArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;

    @java.beans.ConstructorProperties({"name", "price"})
    public Pizza(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
