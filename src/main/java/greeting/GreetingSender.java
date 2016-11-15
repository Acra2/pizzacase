package greeting;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by Sander on 15-11-2016.
 */
public class GreetingSender implements EventSender {
    @Inject
    private Event<String> event;

    @Override
    public void send(String message) {
        event.fire(message);
    }
}
