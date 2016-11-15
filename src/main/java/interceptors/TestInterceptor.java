package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by Sander on 14-11-2016.
 */
@Interceptor
public class TestInterceptor {
    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception{
        Object result = ic.proceed();
        System.out.println("Log method called");

        return result;
    }
}
