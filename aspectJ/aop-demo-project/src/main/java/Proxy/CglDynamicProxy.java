package Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglDynamicProxy implements MethodInterceptor {

    Object targetObject;

    public Object getProxyObject(final Object object) {
        this.targetObject = object;

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(targetObject.getClass());

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method,
                            Object[] args, MethodProxy methodProxy)
            throws Throwable {
        final long startTime = System.currentTimeMillis();
        System.out.println("start transaction in CglDynamicProxy");

        Object result = method.invoke(targetObject, args);

        System.out.println("commit transaction in CglDynamicProxy");
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration in CglDynamicProxy: " + duration);

        return result;
    }
}
