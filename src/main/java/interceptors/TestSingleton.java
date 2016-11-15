package interceptors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by Sander on 14-11-2016.
 */
@Singleton
@Startup
public class TestSingleton {

    @PostConstruct
    public void postConstruct() {
        System.out.println("Singleton postConstruct called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Singleton preDestroy called");
    }

    public String getString() {
        return "Hello from singleton";
    }

//    @Schedule(second ="*/5", minute = "*" , hour = "*")
//private void process() {
//    System.out.println("Hello there!");
//}
}
