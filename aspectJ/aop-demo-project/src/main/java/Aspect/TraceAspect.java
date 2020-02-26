package Aspect;

import Model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TraceAspect {
    private static Logger logger = LogManager.getLogger(TraceAspect.class);

    @Pointcut("execution(public * DAO.UserDao.*(..)) && args(user)")
    public void defineEntryPoint(User user) {
    }

    @Before("defineEntryPoint(user)")
    public void traceIt(final JoinPoint joinPoint, final User user) {
        logger.info("===> executing: " + joinPoint.getSignature()
                + ", args:" + user + ", or args: " + joinPoint.getArgs()[0]);
    }
}