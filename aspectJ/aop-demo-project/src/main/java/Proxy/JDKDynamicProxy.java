package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

    Object targetObject;

    public Object getProxyObject(final Object object){
        this.targetObject=object;
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        final long startTime = System.currentTimeMillis();
        System.out.println("start transaction in JavaDynamicProxy.");
        final Object result = method.invoke(targetObject, args);
        System.out.println("commit transaction in JavaDynamicProxy.");
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration in JavaDynamicProxy: " + duration);

        return result;
    }
}
