package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Created by Sander on 2-11-2016.
 */
@Data
@Entity
@NoArgsConstructor
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Integer id;

    private String name;

    public  Customer(String name){
        this.name = name;
    }

}
