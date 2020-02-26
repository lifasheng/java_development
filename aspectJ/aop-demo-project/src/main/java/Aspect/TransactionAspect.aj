package Aspect;

import Model.User;
import Proxy.JDKDynamicProxy;
import Proxy.CglDynamicProxy;
import Proxy.UserDaoProxy;

aspect TransactionAspect {
    pointcut executeUser():
        execution(public * saveUser(User))
        && !cflow(this(JDKDynamicProxy)) && !cflow(this(CglDynamicProxy)) && !cflow(this(UserDaoProxy));

    Object around(): executeUser() {
        System.out.println("start transaction in TransactionAspect.");
        final Object result = proceed();
        System.out.println("commit transaction in TransactionAspect.");
        return result;
    }
}