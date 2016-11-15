package SoapService;

        import javax.xml.ws.Endpoint;

/**
 * Created by Sander on 10-11-2016.
 */
public class RandPublisher {
    public static void main(String[ ] args) {
        final String url = "http://localhost:8888/rs";
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint.publish(url, new TestService());
    }
}
