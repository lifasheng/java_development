package MyJavaTest;

import DAO.IOrderDao;
import DAO.IUserDao;
import DAO.OrderDao;
import DAO.UserDao;
import Model.Order;
import Model.User;
import Proxy.CglDynamicProxy;
import Proxy.JDKDynamicProxy;
import Proxy.OrderDaoProxy;
import Proxy.UserDaoProxy;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private IUserDao userDao;
    private IOrderDao orderDao;

    @Before
    public void setup() {
        userDao = new UserDao();
        orderDao = new OrderDao();
    }

    @Test
    public void testStaticProxy() {
        final User user1 = new User(1, "Mike");
        IUserDao userDaoStaticProxy = new UserDaoProxy(userDao);
        userDaoStaticProxy.saveUser(user1);

        final Order order1 = new Order(1, user1, Arrays.asList("prod1", "prod2"), 150.8);
        IOrderDao orderDaoStaticProxy = new OrderDaoProxy(orderDao);
        orderDaoStaticProxy.saveOrder(order1);
    }

    @Test
    public void testJDKDynamicProxy() {
        final User user2 = new User(2, "Qy");
        IUserDao userDaoDynamicProxy = (IUserDao) new JDKDynamicProxy().getProxyObject(userDao);
        userDaoDynamicProxy.saveUser(user2);

        final Order order2 = new Order(2, user2, Arrays.asList("prod2", "prod3"), 208);
        IOrderDao orderDaoDynamicProxy = (IOrderDao) new JDKDynamicProxy().getProxyObject(orderDao);
        orderDaoDynamicProxy.saveOrder(order2);
    }

    @Test
    public void testCGLibDynamicProxy() {
        final User user3 = new User(3, "Ky");
        IUserDao userDaoDynamicProxy = (IUserDao) new CglDynamicProxy().getProxyObject(userDao);
        userDaoDynamicProxy.saveUser(user3);

        final Order order3 = new Order(3, user3, Arrays.asList("prod4", "prod7"), 124);
        IOrderDao orderDaoDynamicProxy = (IOrderDao) new CglDynamicProxy().getProxyObject(orderDao);
        orderDaoDynamicProxy.saveOrder(order3);
    }

    @Test
    public void testAspectJ() {
        final User user4 = new User(4, "Lily");
        userDao.saveUser(user4);
    }
}
