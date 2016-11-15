package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by Sander on 15-11-2016.
 */
@Interceptor
@MyInterceptorBinding
public class MyInterceptor {
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        //Object[] parameters = context.getParameters();
//        if (parameters.length > 0 && parameters[0] instanceof String) {
//            String param = (String) parameters[0];
//            parameters[0] = "Hi " + param + " !";
//            context.setParameters(parameters);
//        }
        System.out.println("MyInterceptor called");
        return context.proceed();
    }
}
