package SoapService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Sander on 10-11-2016.
 */
@WebService
public class TestService implements ITestService {

    @WebMethod
    public String helloWorld(){
        return "Hello World!";
    }
}
