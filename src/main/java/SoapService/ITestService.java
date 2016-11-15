package SoapService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Sander on 10-11-2016.
 */
@WebService
public interface ITestService {

    @WebMethod
    public String helloWorld();

}
