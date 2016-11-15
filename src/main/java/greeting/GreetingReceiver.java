package greeting;

import javax.enterprise.event.Observes;

/**
 * Created by Sander on 15-11-2016.
 */

public class GreetingReceiver implements EventReceiver {
    private String greet = "Willkommen";

    void receive(@Observes String greet) {
        this.greet = greet;
    }

    @Override
    public String getGreet() {
        return greet;
    }
}
