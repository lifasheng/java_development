package Aspect;

import Model.User;
import Aspect.TimeMetric;

aspect TimeAspect {
    pointcut executeUser():
        execution(@TimeMetric public * saveUser(User));

    Object around(): executeUser() {
        final long startTime = System.currentTimeMillis();
        final Object result = proceed();
        final long duration = System.currentTimeMillis() - startTime;
        System.out.println("duration in TransactionAspect: " + duration);
        return result;
    }
}